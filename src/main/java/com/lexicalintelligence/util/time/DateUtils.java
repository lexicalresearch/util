package com.lexicalintelligence.util.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	public static final LocalDate MAX_VALUE = new Date(Long.MAX_VALUE).toInstant().atZone(ZoneId.systemDefault())
			.toLocalDate();
	public static final LocalDate MIN_VALUE = new Date(Long.MIN_VALUE).toInstant().atZone(ZoneId.systemDefault())
			.toLocalDate();
	public static final LocalDate TODAY = LocalDate.now();

	/**
	 * 
	 * @param localDate local date to convert
	 * @return date
	 */
	public static final Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 
	 * @param date date to convert
	 * @return local date
	 */
	public static final LocalDate toLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
