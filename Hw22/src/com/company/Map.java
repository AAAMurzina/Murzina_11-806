package com.company;

public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    void printMap();
}