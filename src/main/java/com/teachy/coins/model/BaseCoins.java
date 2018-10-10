package com.teachy.coins.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseCoins {
	private int id;
	private String name;
	private String website;
	private int enable;

	public BaseCoins(String name, String website, int enable) {
		this.name = name;
		this.website = website;
		this.enable = enable;
	}
}
