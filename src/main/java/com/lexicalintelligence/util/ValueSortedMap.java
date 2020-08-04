package com.lexicalintelligence.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Extends {@code java.util.HashMap} to return a view of this map's keys and
 * entries sorted by descending order of the map's values
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class ValueSortedMap<K, V extends Comparable<V>> extends HashMap<K, V> {
	private static final long serialVersionUID = 8376383034090146545L;

	/**
	 * Constructs an empty {@code ValueSortedMap} instance.
	 */
	public ValueSortedMap() {
		super();
	}

	/**
	 * Constructs a {@code ValueSortedMap} instance with the same mappings as the
	 * specified map.
	 *
	 * @param m the map whose mappings are to be placed in this map
	 * @throws NullPointerException if the specified map is null
	 */
	public ValueSortedMap(Map<K, V> m) {
		super(m);
	}

	/**
	 * Returns an ordered {@code java.util.LinkedHashSet} view of the keys contained
	 * in this map sorted by descending order of the map's values
	 *
	 * @return a set view of the keys contained in this map
	 */
	@Override
	public Set<K> keySet() {
		return entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**
	 * Returns an ordered {@code java.util.LinkedHashSet} view of the mappings
	 * contained in this map sorted by descending order of the map's values
	 *
	 * @return a set view of the mappings contained in this map
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Stream<Map.Entry<K, V>> sorted = super.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
		return sorted.collect(Collectors.toCollection(LinkedHashSet::new));
	}
}