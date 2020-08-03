package com.lexicalintelligence.util.time;

import java.time.Month;
import java.time.YearMonth;

/**
 * This class calculates the current fiscal year, defined as the accounting
 * period for the federal government which begins on October 1 and ends on
 * September 30. See <a href=
 * "https://www.senate.gov/reference/glossary_term/fiscal_year.htm">https://www.senate.gov/reference/glossary_term/fiscal_year.htm</a>.
 */
public class FiscalYear {
	/**
	 * Computes the current fiscal year based on today's date.
	 * 
	 * @return the current fiscal year
	 */
	public static final int getYear() {
		YearMonth yearMonth = YearMonth.now();
		if (yearMonth.getMonth().compareTo(Month.SEPTEMBER) > 0
				&& yearMonth.getMonth().compareTo(Month.DECEMBER) <= 0) {
			return yearMonth.getYear() + 1;
		}
		return yearMonth.getYear();
	}

	private FiscalYear() {

	}
}
