package com.got.battleAPI.service;

import com.got.battleAPI.model.responses.Battle;
import com.got.battleAPI.model.responses.CountResponse;
import com.got.battleAPI.model.responses.LocationListResponse;

/**
 * Service layer to fetch necessary data from the Repository
 * @author Jude D'silva
 * 
 * 
 *
 */
public interface BattleAPIService {
	/**
	 * Get the Battle info for a given id
	 * @param id
	 * @return com.got.battle.API.model.responses.Battle
	 */
	public Battle getBattleForId(Integer id);
	
	/**
	 * Get all possible distinct Locations and Regions
	 * @return com.got.battle.API.model.responses.LocationListResponse
	 */
	public LocationListResponse getAllLocs();
	
	
	/**
	 * Get count of total battle records 
	 * @return com.got.battle.API.model.responses.CountResponse
	 */
	public CountResponse getCount();
	
}
