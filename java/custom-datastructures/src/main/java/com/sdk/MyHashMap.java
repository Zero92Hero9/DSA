package com.sdk;

public class MyHashMap<K,V> {
    private static class MyEntry<K,V> {
        K key;
        V value;
        MyEntry<K,V> nextEntry;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    MyEntry<K, V>[] buckets = new MyEntry[16];
    int size = 0;

    public void put(K key, V value) {
        int index = arrayIndex(key);
        MyEntry<K,V> newEntry = new MyEntry<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newEntry;
        } else {
            MyEntry<K,V> temp = buckets[index];
            while (temp.nextEntry != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    return;
                }
                temp = temp.nextEntry;
            }
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }

            temp.nextEntry = newEntry;

        }
        size++;
    }

    public V get(K key) {
        int index = arrayIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        MyEntry<K,V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.nextEntry;
        }

        return null;
    }
    private int arrayIndex(K key) {
        int keyIndex = Math.abs(key.hashCode());
        int compressedIndex = keyIndex % buckets.length;
        
        return compressedIndex;
    }
}
