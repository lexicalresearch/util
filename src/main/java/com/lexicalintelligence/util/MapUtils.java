package com.lexicalintelligence.util;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import com.lexicalintelligence.util.time.DateUtils;

public class MapUtils {
	public static <K, V extends Comparable<V>> V max(Map<K, V> map) {
		if (map == null) {
			return null;
		}
		return map.values().stream().max(new Comparator<V>() {
			@Override
			public int compare(V a, V b) {
				return a.compareTo(b);
			}
		}).orElse(null);
	}

	public static <K, V extends Comparable<V>> V min(Map<K, V> map) {
		if (map == null) {
			return null;
		}
		return map.values().stream().min(new Comparator<V>() {
			@Override
			public int compare(V a, V b) {
				return a.compareTo(b);
			}
		}).orElse(null);
	}

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

	public static Integer getInteger(Map<String, Object> map, String key, int defaultValue) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return defaultValue;
		}
		if (val instanceof Integer) {
			return (Integer) val;
		}
		return Integer.valueOf((String) val);
	}

	public static Date getDate(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return null;
		}
		if (val instanceof Date) {
			return (Date) val;
		} else if (val instanceof LocalDate) {
			return DateUtils.toDate((LocalDate) val);
		}
		throw new IllegalArgumentException(val.getClass() + " cannot be converted to java.util.Date");
	}

	public static Double getDouble(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		if (!validate(val)) {
			return null;
		}
		if (val instanceof Double) {
			return (Double) val;
		}
		return Double.valueOf((String) val);
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

	@SuppressWarnings("unchecked")
	public static Collection<Double> getDoubles(Map<String, Object> map, String key) {
		Object val = getObject(map, key);
		return val != null ? (Collection<Double>) val : Collections.emptyList();
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

	public static Object put(Map<String, Object> map, String key, Object value) {
		if (validate(value)) {
			return map.put(key, value);
		}
		return null;
	}
}
