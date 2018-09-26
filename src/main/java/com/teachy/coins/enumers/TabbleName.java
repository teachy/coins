package com.teachy.coins.enumers;

public enum TabbleName {
	M1("m1", "kline_1m"),
	M5("m5", "kline_5m"),
	M10("m10", "kline_10m"),
	M30("m30", "kline_30m"),
	H1("h1", "kline_1h"),
	H2("h2", "kline_2h"),
	H4("h4", "kline_4h"),
	H12("h12", "kline_12h"),
	H24("h24", "kline_24h");
	private final String key;
	private final String value;

	private TabbleName(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
