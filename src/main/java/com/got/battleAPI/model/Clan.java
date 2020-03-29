package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clan")
public class Clan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClanId")
	Integer clanId;
	
	@Column(name = "ClanName")
	String clanName;
	
	public Clan() {
		
	}

	public Clan(Integer clanId, String clanName) {
		super();
		this.clanId = clanId;
		this.clanName = clanName;
	}

	public Integer getClanId() {
		return clanId;
	}

	public void setClanId(Integer clanId) {
		this.clanId = clanId;
	}

	public String getClanName() throws UnsupportedEncodingException {
		return clanName!= null ? URLDecoder.decode(clanName,"UTF-8") : null;
	}

	public void setClanName(String clanName) throws UnsupportedEncodingException {
		this.clanName = URLEncoder.encode(clanName,"UTF-8");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clanId == null) ? 0 : clanId.hashCode());
		result = prime * result + ((clanName == null) ? 0 : clanName.hashCode());
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
		Clan other = (Clan) obj;
		if (clanId == null) {
			if (other.clanId != null)
				return false;
		} else if (!clanId.equals(other.clanId))
			return false;
		if (clanName == null) {
			if (other.clanName != null)
				return false;
		} else if (!clanName.equals(other.clanName))
			return false;
		return true;
	}

}
