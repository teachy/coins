package com.teachy.coins.enumers;

public enum CoinsType {
	BTC("btc"),
	ETH("eth"),
	USDT("USDT");
	private final String type;

	private CoinsType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
