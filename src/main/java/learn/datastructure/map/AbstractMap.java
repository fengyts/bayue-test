package learn.datastructure.map;

import java.util.Iterator;
import java.util.Set;

public abstract class AbstractMap<K, V> implements MapCustom<K, V> {
	
	transient Set<K> keySet;

	@Override
	public void clear() {
		entrySet().clear();
	}

	@Override
	public String toString() {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (!i.hasNext())
			return "{}";

		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (;;) {
			Entry<K, V> e = i.next();
			K key = e.getKey();
			V value = e.getValue();
			sb.append(key == this ? "(this Map)" : key);
			sb.append('=');
			sb.append(value == this ? "(this Map)" : value);
			if (!i.hasNext())
				return sb.append('}').toString();
			sb.append(',').append(' ');
		}
	}

}
