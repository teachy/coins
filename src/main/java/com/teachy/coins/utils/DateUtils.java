package com.teachy.coins.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {

	public static String convertTimeToString(long time, String pattern) {
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern(pattern);
		return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
	}

	public static String convertTimeToString(long time) {
		return convertTimeToString(time, "yyyy-MM-dd HH:mm:ss");
	}

	public static long differentDays(String time) {
		LocalDateTime btime = StringToDate(time);
		LocalDateTime etime = LocalDateTime.now();
		return differentDays(btime, etime);
	}

	public static long differentDays(String btime, String etime) {
		return differentDays(StringToDate(btime), StringToDate(etime));
	}

	public static long differentDays(LocalDateTime btime, LocalDateTime etime) {
		return ChronoUnit.DAYS.between(btime, etime);
	}

	public static LocalDateTime StringToDate(String time) {
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(time, ftf);
	}

}
