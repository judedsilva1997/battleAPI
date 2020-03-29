package com.got.battleAPI.model.responses;

import java.util.Set;

public class Battle {

	private Integer battleId;

	private BattleType battletype;

	private Integer battleYear;

	private String battleName;

	private Warrior attackerKing;

	private Warrior defenderKing;

	private Set<SideClans> clans;

	private Set<Commanders> commanders;

	private Integer attackerSize;

	private Integer defenderSize;

	private Boolean attackerWin;

	private Integer majorDeath;

	private Integer majorCapture;

	private Location location;

	private String note;

	private Integer summer;

	public Battle() {

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

	public String getBattleName() {
		return battleName;
	}

	public void setBattleName(String battleName) {
		this.battleName = battleName;
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

	public Set<SideClans> getClans() {
		return clans;
	}

	public void setClans(Set<SideClans> clans) {
		this.clans = clans;
	}

	public Set<Commanders> getCommanders() {
		return commanders;
	}

	public void setCommanders(Set<Commanders> commanders) {
		this.commanders = commanders;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getSummer() {
		return summer;
	}

	public void setSummer(Integer summer) {
		this.summer = summer;
	}

}
