package com.got.battleAPI.model.responses;

import java.util.List;

public class LocationListResponse {

	List<Location> list;

	public LocationListResponse() {
	}

	public LocationListResponse(List<Location> list) {
		super();
		this.list = list;
	}

	public List<Location> getList() {
		return list;
	}

	public void setList(List<Location> list) {
		this.list = list;
	}

}
