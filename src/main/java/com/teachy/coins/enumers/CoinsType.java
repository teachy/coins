package com.teachy.coins.enumers;

public enum CoinsType {
	BTC("btc"),
	ETH("eth"),
	USDT("usdt");
	private final String type;

	private CoinsType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
