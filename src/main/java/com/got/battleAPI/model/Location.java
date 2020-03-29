package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="RegionId")
	private Region region;
	
	
	private String locationName;


	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Location(Integer locationId, Region region, String locationName) throws UnsupportedEncodingException {
		super();
		this.locationId = locationId;
		this.region = region;
		this.locationName = java.net.URLEncoder.encode(locationName, "UTF-8");
	}


	public Integer getLocationId() {
		return locationId;
	}


	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public String getLocationName() throws UnsupportedEncodingException {
		return locationName!=null ? java.net.URLDecoder.decode(locationName, "UTF-8") : null;
	}


	public void setLocationName(String locationName) throws UnsupportedEncodingException {
		this.locationName = java.net.URLEncoder.encode(locationName, "UTF-8");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}


	
	
	
	
}
