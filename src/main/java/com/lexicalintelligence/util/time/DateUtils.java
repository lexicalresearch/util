package com.lexicalintelligence.util.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	public static final LocalDate MAX_VALUE = new Date(Long.MAX_VALUE).toInstant().atZone(ZoneId.systemDefault())
			.toLocalDate();
	public static final LocalDate MIN_VALUE = new Date(Long.MIN_VALUE).toInstant().atZone(ZoneId.systemDefault())
			.toLocalDate();
	public static final LocalDate TODAY = LocalDate.now();
}
