package com.got.battleAPI.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Battle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer battleId;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "BattleTypeId")
	private BattleType battletype;

	private Integer battleYear;

	private String battleName;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "AttackerKingId")
	private Warrior attackerKing;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "DefenderKingId")
	private Warrior defenderKing;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "battleId")
	private Set<SideClans> clans;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "battleId")
	private Set<Commanders> commanders;

	private Integer attackerSize;

	private Integer defenderSize;

	private Boolean attackerWin;

	private Integer majorDeath;

	private Integer majorCapture;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LocationId")
	private Location location;

	@Column(length = 300)
	private String note;

	private Integer summer;

	public Battle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBattleId() {
		return battleId;
	}

	public void setBattleId(Integer battleId) {
		this.battleId = battleId;
	}

	public BattleType getBattletype() {
		return battletype;
	}

	public void setBattletype(BattleType battletype) {
		this.battletype = battletype;
	}

	public Integer getBattleYear() {
		return battleYear;
	}

	public void setBattleYear(Integer battleYear) {
		this.battleYear = battleYear;
	}

	public String getBattleName() throws UnsupportedEncodingException {
		return battleName!=null?  URLDecoder.decode(battleName,"UTF-8"):null;
	}

	public void setBattleName(String battleName) throws UnsupportedEncodingException {
		this.battleName = URLEncoder.encode(battleName,"UTF-8");
	}

	public Warrior getAttackerKing() {
		return attackerKing;
	}

	public void setAttackerKing(Warrior attackerKing) {
		this.attackerKing = attackerKing;
	}

	public Warrior getDefenderKing() {
		return defenderKing;
	}

	public void setDefenderKing(Warrior defenderKing) {
		this.defenderKing = defenderKing;
	}

	public Integer getAttackerSize() {
		return attackerSize;
	}

	public void setAttackerSize(Integer attackerSize) {
		this.attackerSize = attackerSize;
	}

	public Integer getDefenderSize() {
		return defenderSize;
	}

	public void setDefenderSize(Integer defenderSize) {
		this.defenderSize = defenderSize;
	}

	public Boolean getAttackerWin() {
		return attackerWin;
	}

	public void setAttackerWin(Boolean attackerWin) {
		this.attackerWin = attackerWin;
	}

	public Integer getMajorDeath() {
		return majorDeath;
	}

	public void setMajorDeath(Integer majorDeath) {
		this.majorDeath = majorDeath;
	}

	public Integer getMajorCapture() {
		return majorCapture;
	}

	public void setMajorCapture(Integer majorCapture) {
		this.majorCapture = majorCapture;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getNote() throws UnsupportedEncodingException {
		return note!=null ? URLDecoder.decode(note,"UTF-8") : null;
	}

	public void setNote(String note) throws UnsupportedEncodingException {
		this.note = URLEncoder.encode(note,"UTF-8");
	}

	public Integer getSummer() {
		return summer;
	}

	public void setSummer(Integer summer) {
		this.summer = summer;
	}

	public Set<Commanders> getCommanders() {
		return commanders;
	}

	public void setCommanders(Set<Commanders> commanders) {
		this.commanders = commanders;
	}
	

	public Set<SideClans> getClans() {
		return clans;
	}

	public void setClans(Set<SideClans> clans) {
		this.clans = clans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note== null) ? 0 : note.hashCode());
		result = prime * result + ((attackerKing == null) ? 0 : attackerKing.hashCode());
		result = prime * result + ((attackerSize == null) ? 0 : attackerSize.hashCode());
		result = prime * result + ((attackerWin == null) ? 0 : attackerWin.hashCode());
		result = prime * result + ((battleId == null) ? 0 : battleId.hashCode());
		result = prime * result + ((battleName == null) ? 0 : battleName.hashCode());
		result = prime * result + ((battleYear == null) ? 0 : battleYear.hashCode());
		result = prime * result + ((battletype == null) ? 0 : battletype.hashCode());
		result = prime * result + ((defenderKing == null) ? 0 : defenderKing.hashCode());
		result = prime * result + ((defenderSize == null) ? 0 : defenderSize.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((majorCapture == null) ? 0 : majorCapture.hashCode());
		result = prime * result + ((majorDeath == null) ? 0 : majorDeath.hashCode());
		result = prime * result + ((summer == null) ? 0 : summer.hashCode());
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
		Battle other = (Battle) obj;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (attackerKing == null) {
			if (other.attackerKing != null)
				return false;
		} else if (!attackerKing.equals(other.attackerKing))
			return false;
		if (attackerSize == null) {
			if (other.attackerSize != null)
				return false;
		} else if (!attackerSize.equals(other.attackerSize))
			return false;
		if (attackerWin == null) {
			if (other.attackerWin != null)
				return false;
		} else if (!attackerWin.equals(other.attackerWin))
			return false;
		if (battleId == null) {
			if (other.battleId != null)
				return false;
		} else if (!battleId.equals(other.battleId))
			return false;
		if (battleName == null) {
			if (other.battleName != null)
				return false;
		} else if (!battleName.equals(other.battleName))
			return false;
		if (battleYear == null) {
			if (other.battleYear != null)
				return false;
		} else if (!battleYear.equals(other.battleYear))
			return false;
		if (battletype == null) {
			if (other.battletype != null)
				return false;
		} else if (!battletype.equals(other.battletype))
			return false;
		if (defenderKing == null) {
			if (other.defenderKing != null)
				return false;
		} else if (!defenderKing.equals(other.defenderKing))
			return false;
		if (defenderSize == null) {
			if (other.defenderSize != null)
				return false;
		} else if (!defenderSize.equals(other.defenderSize))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (majorCapture == null) {
			if (other.majorCapture != null)
				return false;
		} else if (!majorCapture.equals(other.majorCapture))
			return false;
		if (majorDeath == null) {
			if (other.majorDeath != null)
				return false;
		} else if (!majorDeath.equals(other.majorDeath))
			return false;
		if (summer == null) {
			if (other.summer != null)
				return false;
		} else if (!summer.equals(other.summer))
			return false;
		return true;
	}

}
