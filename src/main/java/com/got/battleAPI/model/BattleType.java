package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BattleType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer battleTypeId;
	
	private String battleType;

	public BattleType(Integer battleTypeId, String battleType) throws UnsupportedEncodingException {
		super();
		this.battleTypeId = battleTypeId;
		this.battleType = URLEncoder.encode(battleType,"UTF-8");
	}
	
	public BattleType() {
	
	}

	public Integer getBattleTypeId() {
		return battleTypeId;
	}

	public void setBattleTypeId(Integer battleTypeId) {
		this.battleTypeId = battleTypeId;
	}

	public String getBattleType() throws UnsupportedEncodingException {
		return URLDecoder.decode(battleType,"UTF-8");
	}

	public void setBattleType(String battleType) throws UnsupportedEncodingException {
		this.battleType = URLEncoder.encode(battleType,"UTF-8");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((battleType == null) ? 0 : battleType.hashCode());
		result = prime * result + ((battleTypeId == null) ? 0 : battleTypeId.hashCode());
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
		BattleType other = (BattleType) obj;
		if (battleType == null) {
			if (other.battleType != null)
				return false;
		} else if (!battleType.equals(other.battleType))
			return false;
		if (battleTypeId == null) {
			if (other.battleTypeId != null)
				return false;
		} else if (!battleTypeId.equals(other.battleTypeId))
			return false;
		return true;
	}
	
	
	
}
