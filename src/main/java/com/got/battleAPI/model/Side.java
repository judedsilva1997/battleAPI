package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Side {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sideId;
	
	private String sideType;

	public Integer getSideId() {
		return sideId;
	}

	public void setSideId(Integer sideId) {
		this.sideId = sideId;
	}

	public String getSideType() throws UnsupportedEncodingException {
		return sideType != null ? URLDecoder.decode(sideType,"UTF-8"):null;
	}

	public void setSideType(String sideType) throws UnsupportedEncodingException {
		this.sideType = URLEncoder.encode(sideType, "UTF-8");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sideId == null) ? 0 : sideId.hashCode());
		result = prime * result + ((sideType == null) ? 0 : sideType.hashCode());
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
		Side other = (Side) obj;
		if (sideId == null) {
			if (other.sideId != null)
				return false;
		} else if (!sideId.equals(other.sideId))
			return false;
		if (sideType == null) {
			if (other.sideType != null)
				return false;
		} else if (!sideType.equals(other.sideType))
			return false;
		return true;
	}
	
	
		
}
