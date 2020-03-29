package com.got.battleAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.got.battleAPI.model.responses.Battle;
import com.got.battleAPI.model.responses.CountResponse;
import com.got.battleAPI.model.responses.Location;
import com.got.battleAPI.model.responses.LocationListResponse;
import com.got.battleAPI.repository.BattleRepository;
import com.got.battleAPI.repository.LocationRepository;


@Service
public class BattleAPIServiceImpl implements BattleAPIService {
	
	@Autowired
	BattleRepository battleRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	Mapper mapper;

	@Override
	public Battle getBattleForId(Integer id) {
		Optional<com.got.battleAPI.model.Battle> response= battleRepository.findById(id);
		return mapper.map(response.orElseThrow(()-> new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "Battle not found"
				)),Battle.class);
	}

	@Override
	public LocationListResponse getAllLocs() {
		Iterable<com.got.battleAPI.model.Location> locationData = locationRepository.findAll();
		List<com.got.battleAPI.model.Location> response  = new ArrayList<com.got.battleAPI.model.Location>();
		locationData.forEach(response::add);
		List<Location> result = response.stream().map(x -> mapper.map(x, Location.class)).distinct().collect(Collectors.toList());
		return new LocationListResponse(result);
	}

	@Override
	public CountResponse getCount() {
		Long count =  battleRepository.count();
		return new CountResponse(Integer.valueOf(count.toString()));
	}

}
