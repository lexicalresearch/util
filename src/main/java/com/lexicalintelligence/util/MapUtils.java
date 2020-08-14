package com.lexicalintelligence.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MapUtils {

	public static boolean getBoolean(Map<String, Object> doc, String key) {
		Object val = doc.get(key);
		if (!validate(val)) {
			return false;
		}
		if (val instanceof Boolean) {
			return (Boolean) val;
		}
		if (val instanceof String) {
			return Boolean.valueOf((String) val);
		}
		if (val instanceof Integer) {
			return 1 == (int) val;
		}
		return (boolean) val;
	}

	public static Integer getInteger(Map<String, Object> doc, String key) {
		Object val = doc.get(key);
		if (!validate(val)) {
			return null;
		}
		if (val instanceof Integer) {
			return (Integer) val;
		}
		return Integer.valueOf((String) val);
	}

	public static String getString(Map<String, Object> doc, String key) {
		Object val = doc.get(key);
		if (!validate(val)) {
			return null;
		}
		return val.toString();
	}

	public static Collection<String> getStrings(Map<String, Object> doc, String key) {
		@SuppressWarnings("unchecked")
		Collection<String> val = (Collection<String>) doc.get(key);
		return val != null ? val : Collections.emptyList();
	}

	public static Collection<Integer> getIntegers(Map<String, Object> doc, String key) {
		@SuppressWarnings("unchecked")
		Collection<Integer> val = (Collection<Integer>) doc.get(key);
		return val != null ? val : Collections.emptyList();
	}

	@SuppressWarnings("rawtypes")
	public static boolean validate(Object value) {
		if (value == null) {
			return false;
		}
		if (value instanceof String) {
			if (((String) value).isBlank()) {
				return false;
			}
		} else if (value instanceof Collection) {
			if (((Collection) value).isEmpty()) {
				return false;
			}
		} else if (value instanceof Map) {
			if (((Map) value).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static void put(Map<String, Object> doc, String key, Object value) {
		if (validate(value)) {
			doc.put(key, value);
		}
	}
}
