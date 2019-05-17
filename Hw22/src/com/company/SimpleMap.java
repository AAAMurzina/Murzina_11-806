package com.company;

public class SimpleMap<K, V> implements Map<K, V> {
    Entry[] entries;
    int n = 0;
    int size;

    public SimpleMap(int size) {
        entries = new Entry[size];
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        if(n >= size){
            size++;
            Entry[] newEntries = new Entry[size];
            for (int i = 0; i < size - 1; i++) {
                newEntries[i] = entries[i];
            }
            entries = newEntries;
        }
        for (int i = 0; i < n; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        entries[n] = newEntry;
        n++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < n; i++) {
            if (entries[i].key.equals(key)) {
                return (V) entries[i].value;
            }
        }
        return null;
    }

    @Override
    public void printMap(){
        for (int i = 0; i < entries.length - 1; i++) {
            System.out.println(entries[i].key + " " + entries[i].value);
        }
    }

    class Entry<A, B> {
        A key;
        B value;

        public Entry(A key, B value) {
            this.key = key;
            this.value = value;
        }
    }
}