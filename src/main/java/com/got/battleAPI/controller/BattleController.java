package com.got.battleAPI.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.got.battleAPI.model.responses.Battle;
import com.got.battleAPI.model.responses.CountResponse;
import com.got.battleAPI.model.responses.LocationListResponse;
import com.got.battleAPI.service.BattleAPIService;


/**
 * Controller for accessing the end points
 * @author Jude D'silva
 *
 */
@RestController
@RequestMapping("/battleapi")
public class BattleController {
	
	@Autowired
	BattleAPIService service;
	
	@RequestMapping(value = "/test")
	public String testEndpoint() throws UnsupportedEncodingException {
		return "Server is up and running";
	}
	
	@RequestMapping(value = "/battle/{id}", method = RequestMethod.GET)
	public Battle getBattleData(@PathVariable("id") Integer id ) throws UnsupportedEncodingException {
		return service.getBattleForId(id);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public LocationListResponse getLocationList() throws UnsupportedEncodingException {
		return service.getAllLocs();
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public CountResponse getCount() throws UnsupportedEncodingException {
		return service.getCount();
	}

}
