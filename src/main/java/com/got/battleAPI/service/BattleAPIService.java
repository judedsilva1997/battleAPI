package com.got.battleAPI.service;

import com.got.battleAPI.model.responses.Battle;
import com.got.battleAPI.model.responses.CountResponse;
import com.got.battleAPI.model.responses.LocationListResponse;

public interface BattleAPIService {
	
	public Battle getBattleForId(Integer id);
	
	public LocationListResponse getAllLocs();
	
	public CountResponse getCount();
	
}
