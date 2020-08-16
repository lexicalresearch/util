package com.lexicalintelligence.util;

/**
 * This class consists of static methods that generalize input values to
 * {@code java.lang.Boolean#valueOf}
 */
public class BooleanUtils {
	/**
	 * Returns a {@code Boolean} with a true value if the Integer argument is not
	 * null and is equal to {@code 1}
	 *
	 * @param b an integer
	 * @return the {@code Boolean} value represented by the integer
	 */
	public static final Boolean valueOf(Integer b) {
		return b != null && valueOf(b.intValue());
	}

	/**
	 * Returns a {@code Boolean} with a true value if the int argument is equal to 1
	 *
	 * @param b an int
	 * @return the {@code Boolean} value represented by the int
	 */
	public static final Boolean valueOf(int b) {
		return b == 1;
	}

	/**
	 * Returns a {@code Boolean} with a true value if and only if it satisfies one
	 * of the following criteria.
	 * 
	 * <ul>
	 * <li>the string argument is equal to the string {@code "1"}
	 * <li>the string argument is equal, ignoring case, to the string {@code "Yes"}
	 * <li>{@code java.lang.Boolean#valueOf(String)} returns a true value for the
	 * string argument
	 * </ul>
	 *
	 * @param s a string
	 * 
	 * @return the {@code Boolean} value represented by the string
	 */
	public static final Boolean valueOf(String s) {
		if ("1".equals(s) || "Yes".equalsIgnoreCase(s)) {
			return true;
		}
		return Boolean.valueOf(s);
	}
}
