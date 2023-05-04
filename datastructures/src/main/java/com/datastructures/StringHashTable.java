package com.datastructures;

import java.util.ArrayList;

public class StringHashTable<T> {

    private class KeyValuePair {
        private String key;
        private T value;
        
        public KeyValuePair(String key, T value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static final int DEFAULT_SIZE = 17;


    private KeyValuePair[] pairs;
    
    public StringHashTable() {
        this(DEFAULT_SIZE);
    }

    public StringHashTable(int size) {

    }

    public T get(String key, T _default) {
        return _default;
    }

    public void set(String key, T value) {

    }

    public boolean contains(String key) {
        return false;
    }

    public T delete(String key) {
        return null;
    }

    public int size() {
        return 0;
    }

}
