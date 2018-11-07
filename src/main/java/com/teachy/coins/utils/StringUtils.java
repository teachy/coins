package com.teachy.coins.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	/**
	 *
	 * @return UUID
	 */
	public static String getUUid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getRegexStr(String sourceStr, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		if (m.find()) {
			return m.group(1);
		}

		return null;
	}
}
