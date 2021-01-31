package com.lexicalintelligence.util;

import java.util.Collection;
import java.util.LinkedHashMap;

public class TypeAwareLinkedHashMap extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 8577788718062451879L;

	public Boolean getBoolean(String key) {
		return MapUtils.getBoolean(this, key);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {
		Boolean val = getBoolean(key);
		return val == null ? defaultValue : val;
	}

	public Double getDouble(String key) {
		return MapUtils.getDouble(this, key);
	}

	public Collection<Double> getDoubles(String key) {
		return MapUtils.getDoubles(this, key);
	}

	public Integer getInteger(String key) {
		return MapUtils.getInteger(this, key);
	}

	public Collection<Integer> getIntegers(String key) {
		return MapUtils.getIntegers(this, key);
	}

	public String getString(String key) {
		return MapUtils.getString(this, key);
	}

	public Collection<String> getStrings(String key) {
		return MapUtils.getStrings(this, key);
	}

	public Object getObject(String key) {
		return MapUtils.getObject(this, key);
	}

	public Object get(String key) {
		return MapUtils.getObject(this, key);
	}

	@Override
	public Object put(String key, Object value) {
		if (MapUtils.validate(value)) {
			return super.put(key, value);
		}
		return null;
	}

	public static void main(String[] args) {
		var m = new TypeAwareLinkedHashMap();
		var n = new TypeAwareLinkedHashMap();
		n.put("b", "okay");
		m.put("a", n);

		System.out.println(m);

		System.out.println(m.getString("a.b"));
	}
}
