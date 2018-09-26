package com.teachy.coins.utils;

import java.util.UUID;

public class StringUtils {
	/**
	 *
	 * @return UUID
	 */
	public static String getUUid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
