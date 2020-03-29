package com.got.battleAPI.model.responses;

public class Commanders {

	private Side side;

	private Warrior clan;

	public Commanders() {

	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Warrior getClan() {
		return clan;
	}

	public void setClan(Warrior clan) {
		this.clan = clan;
	}

}
