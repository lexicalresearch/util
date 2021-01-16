package com.lexicalintelligence.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MapUtils {

	public static Boolean getBoolean(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return null;
		}
		if (val instanceof String) {
			return BooleanUtils.valueOf((String) val);
		}
		if (val instanceof Integer) {
			return BooleanUtils.valueOf((Integer) val);
		}
		return (Boolean) val;
	}

	public static Integer getInteger(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return null;
		}
		if (val instanceof Integer) {
			return (Integer) val;
		}
		return Integer.valueOf((String) val);
	}

	public static String getString(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return null;
		}
		return val.toString();
	}

	@SuppressWarnings("unchecked")
	public static Collection<String> getStrings(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		return val != null ? (Collection<String>) val : Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	public static Collection<Integer> getIntegers(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		return val != null ? (Collection<Integer>) val : Collections.emptyList();
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

	@SuppressWarnings("unchecked")
	public static Object getObject(Map<String, Object> map, String key) {
		if (map == null) {
			return null;
		}
		var val = map.get(key);
		if (val != null || !key.contains(".")) {
			return val;
		}
		var keyParts = key.split("[.]");
		Map<String, Object> result = map;
		for (int i = 0; i < keyParts.length; i++) {
			val = result.get(keyParts[i]);
			if (val == null) {
				break;
			}
			if (val instanceof Map) {
				result = (Map<String, Object>) val;
			}
		}
		return val;
	}

	public static void put(Map<String, Object> doc, String key, Object value) {
		if (validate(value)) {
			doc.put(key, value);
		}
	}
}
