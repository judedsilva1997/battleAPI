package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Warrior")
public class Warrior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WarriorId")
    private Integer warriorId;
    
    @Column(name = "WarriorName")
    private String warriorName;
    
	public Warrior() {

	}

	public Warrior( String warriorName) throws UnsupportedEncodingException {
	
		warriorName = java.net.URLEncoder.encode(warriorName, "UTF-8");
	}

	public Integer getWarriorId() {
		return warriorId;
	}

	public void setWarriorId(Integer warriorId) {
		this.warriorId = warriorId;
	}

	public String getWarriorName() throws UnsupportedEncodingException {
		return warriorName!= null ? java.net.URLDecoder.decode(warriorName, "UTF-8") : null;
	}

	public void setWarriorName(String warriorName) throws UnsupportedEncodingException {
		this.warriorName = java.net.URLEncoder.encode(warriorName, "UTF-8");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((warriorId == null) ? 0 : warriorId.hashCode());
		result = prime * result + ((warriorName == null) ? 0 : warriorName.hashCode());
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
		Warrior other = (Warrior) obj;
		if (warriorId == null) {
			if (other.warriorId != null)
				return false;
		} else if (!warriorId.equals(other.warriorId))
			return false;
		if (warriorName == null) {
			if (other.warriorName != null)
				return false;
		} else if (!warriorName.equals(other.warriorName))
			return false;
		return true;
	}


}