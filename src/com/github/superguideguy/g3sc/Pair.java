package com.github.superguideguy.g3sc;

// A class I took from a former project of mine
public class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K,V>> {

	private final K key;
	private final V value;
	
	public Pair(K k, V v) {
		key = k;
		value = v;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) return false;
		Pair<?, ?> obj = (Pair<?, ?>) o;
		if (!(key.equals(obj.key))) return false;
		if (!(value.equals(obj.value))) return false;
		return true;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public int hashCode() {
		return key.hashCode() + (31 * value.hashCode());
	}
	
	public String toString() {
		return key.toString() + "=" + value.toString(); //$NON-NLS-1$
	}

	@Override
	public int compareTo(Pair<K,V> o) {
		return key.compareTo(o.key);
	}
	
}
