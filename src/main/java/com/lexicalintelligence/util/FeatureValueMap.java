package com.lexicalintelligence.util;

import java.util.Map;

public class FeatureValueMap<K> extends TypeAwareLinkedHashMap {
	private static final long serialVersionUID = -3021697119517545289L;

	public FeatureValueMap() {

	}

	public FeatureValueMap(K id, Double value) {
		this(id, null, value);
	}

	public FeatureValueMap(K id, String name, Double value) {
		setId(id);
		setName(name);
		setValue(value);
	}

	@SuppressWarnings("unchecked")
	public FeatureValueMap(Map<K, Object> map) {
		this((K) map.get("id"), (String) map.get("name"), (Double) map.get("value"));
	}

	public void setId(K id) {
		super.put("id", id);
	}

	@SuppressWarnings("unchecked")
	public void setName(String name) {
		put("name", name);
		if (get("id") == null) {
			setId((K) name);
		}
	}

	public void setValue(Double value) {
		super.put("value", value);
	}

	public String getName() {
		return getString("name");
	}

	public Double getValue() {
		return getDouble("value");
	}

	public static void main(String[] args) {
		var fvm = new FeatureValueMap<Integer>(1, 2.0);
		System.out.println(fvm);

		// var list = new FeatureValueList<Integer>();

		// list.add(fvm);

		// System.out.println(list);
	}
}
