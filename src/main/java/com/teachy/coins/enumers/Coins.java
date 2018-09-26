package com.teachy.coins.enumers;

public enum Coins {
	BTC("btc"),
	ETH("eth"),
	GEMS("gems");
	private final String name;

	private Coins(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
