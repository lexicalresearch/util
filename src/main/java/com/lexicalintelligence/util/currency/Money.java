package com.lexicalintelligence.util.currency;

import java.text.NumberFormat;

/**
 * This class consists of static methods that operate on currencies with
 * defaults for the current locale.
 */
public class Money {
	private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();

	/**
	 * Returns a currency format for the current default locale with whole amounts
	 * truncated.
	 * 
	 * @param currency the double currency to format
	 * @return the formatted currency as a {@code String}
	 */
	public static final String format(double currency) {
		String formatted = formatter.format(currency);
		if (formatted.endsWith(".00")) {
			return formatted.replaceFirst("[.]00$", "");
		}
		return formatted;
	}

	/**
	 * @see Money#format(int)
	 * 
	 * @param currency the int currency to format
	 * @return the formatted currency as a {@code String}
	 */
	public static final String format(int currency) {
		return format((double) currency);
	}
}
