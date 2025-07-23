class Entry<K,V> {
	K key;
	V value;
	Entry<K,V> next;

	public Entry(K key, V value, Entry<K,V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

class RKHash {
	int capacity;
	Entry<K,V>[] table;
	int size;

	public RKHash(int capacity) {
		this.capacity = capacity;
		table = new Entry<K,V>[capacity];
	}

	public int getIndex(K key) {
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode()) % capacity;
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		Entry<K,V> entry = new Entry(key, value, null);

		if (table[index] == null) {
			table[index] = entry;
		} else {
			Entry<K,V> current = table[index];
			while (current.next != null) {
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;				
			}

			current.next = entry;

		}
		size++;
	}

	public V get(K key) {
		int index = getIndex(key);

		if (table[index] != null) {
			return 
		}
	}

}

public class HashtablePlayground {
	
}