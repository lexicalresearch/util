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
	 * Returns the earlier of a {@code Date} value and a {@code LocalDate} value as
	 * a {@code LocalDate} object
	 *
	 * @param a a date
	 * @param b another date
	 * @return the earlier of {@code a} and {@code b}.
	 */
	public static final LocalDate min(Date a, LocalDate b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return toLocalDate(a);
		}
		LocalDate c = toLocalDate(a);
		return c.isBefore(b) ? c : b;
	}

	/**
	 * Returns the earlier of a {@code Date} value and a {@code LocalDate} value as
	 * a {@code LocalDate} object
	 *
	 * @param a a date
	 * @param b another date
	 * @return the earlier of {@code a} and {@code b}.
	 */
	public static final LocalDate min(LocalDate a, Date b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return toLocalDate(b);
		}
		if (b == null) {
			return a;
		}
		LocalDate c = toLocalDate(b);
		return a.isBefore(c) ? a : c;
	}

	/**
	 * Returns the earlier of two {@code LocalDate} values
	 *
	 * @param a a date
	 * @param b another date
	 * @return the earlier of {@code a} and {@code b}.
	 */
	public static final LocalDate min(LocalDate a, LocalDate b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return a.isBefore(b) ? a : b;
	}

	/**
	 * Returns the later of two {@code LocalDate} values
	 *
	 * @param a a date
	 * @param b another date
	 * @return the later of {@code a} and {@code b}.
	 */

	public static final LocalDate max(LocalDate a, LocalDate b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return a.isAfter(b) ? a : b;
	}

	/**
	 * Returns the earlier of two {@code Date} values
	 *
	 * @param a a date
	 * @param b another date
	 * @return the earlier of {@code a} and {@code b}.
	 */
	public static final Date min(Date a, Date b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return a.before(b) ? a : b;
	}

	/**
	 * Returns the later of two {@code Date} values
	 *
	 * @param a a date
	 * @param b another date
	 * @return the later of {@code a} and {@code b}.
	 */

	public static final Date max(Date a, Date b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		return a.after(b) ? a : b;
	}

	/**
	 * Converts a {@code LocalDate} argument to a {@code Date} object using system
	 * defaults
	 * 
	 * @param localDate local date to convert
	 * @return date
	 */
	public static final Date toDate(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Converts a {@code Date} argument to a {@code LocalDate} object using system
	 * defaults
	 * 
	 * @param date date to convert
	 * @return local date
	 */
	public static final LocalDate toLocalDate(Date date) {
		if (date == null) {
			return null;
		}
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
