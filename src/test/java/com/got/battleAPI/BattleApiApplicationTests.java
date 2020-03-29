package com.got.battleAPI;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.got.battleAPI.model.Battle;
import com.got.battleAPI.model.Location;
import com.got.battleAPI.model.Region;
import com.got.battleAPI.model.responses.CountResponse;
import com.got.battleAPI.model.responses.ErrorClass;
import com.got.battleAPI.model.responses.LocationListResponse;
import com.got.battleAPI.repository.BattleRepository;
import com.got.battleAPI.repository.LocationRepository;
import com.mysql.cj.protocol.Message;

/**
 * Integration tests written with an aim to cover test cases as well as test end to end flows
 * @author Jude
 *
 */

@SpringBootTest
class BattleApiApplicationTests {

	@Autowired
	WebApplicationContext wac;
	
	@MockBean
	LocationRepository locationRepository;
	
	@MockBean
	BattleRepository battleRepository;
	
	MockMvc mvc;

	@Test
	void contextLoads() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/test")).andExpect(status().isOk());
	}
	
	@Test
	void test_getLocationList() throws Exception {
		when(locationRepository.findAll()).thenReturn(new ArrayList<Location>() {
			{
				add(new Location(1, new Region(1,"A"), "A1"));
				add(new Location(2, new Region(3,"B"), "B2"));
			}
		});
		
		List <com.got.battleAPI.model.responses.Location> list = new ArrayList<com.got.battleAPI.model.responses.Location>() {
			{
				add(new com.got.battleAPI.model.responses.Location( new com.got.battleAPI.model.responses.Region("A"), "A1"));
				add(new com.got.battleAPI.model.responses.Location( new com.got.battleAPI.model.responses.Region("B"), "B2"));
			}
		};
		LocationListResponse response = new LocationListResponse(list);
		
		
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		ObjectMapper mapper = new ObjectMapper();
		
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/list")).andExpect(status().isOk()).andExpect(content().json(mapper.writeValueAsString(response)));
	}
	
	@Test
	void test_getLocationList_0() throws Exception {
		when(locationRepository.findAll()).thenReturn(new ArrayList<Location>() );
		
		List <com.got.battleAPI.model.responses.Location> list = new ArrayList<com.got.battleAPI.model.responses.Location>();
		LocationListResponse response = new LocationListResponse(list);
		
		
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		ObjectMapper mapper = new ObjectMapper();
		
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/list")).andExpect(status().isOk()).andExpect(content().json(mapper.writeValueAsString(response)));
	}
	
	@Test
	void test_getCount() throws JsonProcessingException, Exception {
		when(battleRepository.count()).thenReturn((long) 15);
		CountResponse response = new CountResponse(15);
		ObjectMapper mapper = new ObjectMapper();
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/count")).andExpect(status().isOk()).andExpect(content().json(mapper.writeValueAsString(response)));
	}
	
	@Test
	void test_getBattleInfoWrongId() throws JsonProcessingException, Exception {
		when(battleRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.empty());
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/battle/3")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	void test_getBattleInfonogId() throws JsonProcessingException, Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/battle")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	void test_getBattle() throws JsonProcessingException, Exception {
		Battle battle = new Battle();
		battle.setBattleName("Yo");
		battle.setBattleId(3);
		battle.setBattleYear(123);
		
		com.got.battleAPI.model.responses.Battle response = new com.got.battleAPI.model.responses.Battle();
		response.setBattleId(3);
		response.setBattleName("Yo");
		response.setBattleYear(123);
		
		ObjectMapper mapper = new ObjectMapper();
		when(battleRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.ofNullable(battle));
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mvc.perform(MockMvcRequestBuilders.get("/battleapi/battle/3")).andDo(print()).andExpect(status().isOk()).andExpect(content().json(mapper.writeValueAsString(response)));
	}
	
	

}
