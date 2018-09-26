package com.teachy.coins.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String convertTimeToString(long time,String pattern) {
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern(pattern);
		return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
	}

	public static String convertTimeToString(long time) {
		return convertTimeToString(time,"yyyy-MM-dd HH:mm:ss");
	}
}
