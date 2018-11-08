package com.teachy.coins.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
	private static String formatter = "yyyy-MM-dd HH:mm:ss";
	private static final DateTimeFormatter ftf = DateTimeFormatter.ofPattern(formatter);

	public static String convertTimeToString(long time, String pattern) {
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern(pattern);
		return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
	}

	public static String convertTimeToString(long time) {
		return convertTimeToString(time, formatter);
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
		return LocalDateTime.parse(time, ftf);
	}

	public static String plusDay(int num, String time) {
		DateTimeFormatter ftf = getDateTimeFormatter("yyyy-MM-dd");
		LocalDate btime = LocalDate.parse(time, ftf);
		return btime.plusDays(num).format(ftf);
	}

	public static DateTimeFormatter getDateTimeFormatter(String formatter) {
		return DateTimeFormatter.ofPattern(formatter);
	}

}
