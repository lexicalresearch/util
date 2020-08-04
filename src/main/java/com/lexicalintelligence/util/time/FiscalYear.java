package com.lexicalintelligence.util.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

/**
 * This class contains static methods for obtaining the fiscal year, defined as
 * the accounting period for the federal government which begins on October 1
 * and ends on September 30, from dates. See <a href=
 * "https://www.senate.gov/reference/glossary_term/fiscal_year.htm">https://www.senate.gov/reference/glossary_term/fiscal_year.htm</a>.
 */
public class FiscalYear {
	/**
	 * Obtains the current fiscal year from the system clock in the default
	 * time-zone
	 * 
	 * @return the current fiscal year as an {@code int}
	 */
	public static final int getYear() {
		return getYear(YearMonth.now());
	}

	/**
	 * Obtains the fiscal year from a month and year
	 * 
	 * @param month the month-of-year to use, from 1 to 12
	 * @param year  the year to use
	 * @return the fiscal year as an {@code int}
	 */
	public static int getYear(int month, int year) {
		if (Month.of(month).compareTo(Month.SEPTEMBER) > 0 && Month.of(month).compareTo(Month.DECEMBER) <= 0) {
			return year + 1;
		}
		return year;
	}

	/**
	 * Obtains the fiscal year from a year month object
	 * 
	 * @param yearMonth the {@code java.time.YearMonth} object to use, not null
	 * @return the fiscal year as an {@code int}
	 */
	public static int getYear(YearMonth yearMonth) {
		return getYear(yearMonth.getMonthValue(), yearMonth.getYear());
	}

	/**
	 * Obtains the fiscal year from a local date object
	 * 
	 * @param date the {@code java.time.LocalDate} object to use, not null
	 * @return the fiscal year as an {@code int}
	 */
	public static int getYear(LocalDate date) {
		return getYear(date.getMonthValue(), date.getYear());
	}

	/**
	 * Obtains the fiscal year from a date object using the default time zone
	 * 
	 * @param date the {@code java.util.Date} object to use, not null
	 * @return the fiscal year as an {@code int}
	 */
	public static int getYear(Date date) {
		return getYear(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
	}

	private FiscalYear() {

	}
}
