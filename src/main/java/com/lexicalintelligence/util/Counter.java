package com.lexicalintelligence.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Counter<K> implements Iterable<Map.Entry<K, Integer>> {
	private Map<K, Integer> data = new ValueSortedMap<>();

	public Counter() {

	}

	public Counter(Collection<K> collection) {
		addAll(collection);
	}

	public synchronized Integer get(K key) {
		return data.getOrDefault(key, 0);
	}

	public synchronized void add(K k) {
		add(k, 1);
	}

	public synchronized void add(K key, int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Value must be greater than 0");
		}
		data.put(key, value + data.getOrDefault(key, 0));
	}

	public synchronized void addAll(Collection<K> ks) {
		if (ks != null) {
			ks.forEach(this::add);
		}
	}

	public int sum() {
		return data.values().stream().reduce(0, Integer::sum);
	}

	public synchronized Counter<K> top(int n) {
		if (n >= data.size()) {
			return this;
		}
		int count = 0;
		Collection<K> keys = data.keySet();
		for (K key : keys) {
			if (++count > n) {
				data.remove(key);
			}
		}
		return this;
	}

	public synchronized Counter<K> limit(int n) {
		Collection<K> keys = data.keySet();
		for (K key : keys) {
			if (data.get(key) < n) {
				data.remove(key);
			}
		}
		return this;
	}

	public int min() {
		if (data.isEmpty()) {
			return 0;
		}
		return data.values().stream().min(Integer::compare).get();
	}

	public int max() {
		if (data.isEmpty()) {
			return 0;
		}
		return data.values().stream().max(Integer::compare).get();
	}

	public Collection<K> keySet() {
		return data.keySet();
	}

	public Collection<Integer> values() {
		return data.values();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Iterator<Entry<K, Integer>> iterator() {
		return data.entrySet().iterator();
	}

	@Override
	public String toString() {
		return data.toString();
	}
}