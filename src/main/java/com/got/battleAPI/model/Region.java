package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer regionId;
	
	String regionName;
	
	public Region() {
	
	}

	public Region(Integer regionId, String regionName) throws UnsupportedEncodingException {
		super();
		this.regionId = regionId;
		this.regionName = java.net.URLEncoder.encode(regionName, "UTF-8");
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() throws UnsupportedEncodingException {
		return regionName!=null ? java.net.URLDecoder.decode(regionName, "UTF-8") : null;
	}

	public void setRegionName(String regionName) throws UnsupportedEncodingException {
		this.regionName = java.net.URLEncoder.encode(regionName, "UTF-8");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
		result = prime * result + ((regionName == null) ? 0 : regionName.hashCode());
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
		Region other = (Region) obj;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		if (regionName == null) {
			if (other.regionName != null)
				return false;
		} else if (!regionName.equals(other.regionName))
			return false;
		return true;
	}
	
	

}
