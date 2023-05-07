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
    // (sqrt(5) - 1) / 2
    private static final double A = 0.6180339887498949;


    private ArrayList<ArrayList<KeyValuePair>> pairs;
    private int size;
    
    public StringHashTable() {
        this(DEFAULT_SIZE);
    }

    public StringHashTable(int size) {
        pairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            pairs.add(new ArrayList<>());
        }
        this.size = size;
    }


    private int getHash(String key) {
        if (key.equals("")) {
            return 0;
        }

        char firstChar = key.charAt(0);
        return (int)Math.floor(size * (A * firstChar % 1));
    }

    private int getKeyIndex(String key, int hash) {
        int index = 0;
        for (KeyValuePair pair : pairs.get(hash)) {
            if (pair.getKey().equals(key)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    public T get(String key, T _default) {
        int hash = getHash(key);
        int index = getKeyIndex(key, hash);
        if (index >= 0) {
            return pairs.get(hash).get(index).getValue();
        }
        return _default;
    }

    public void set(String key, T value) {
        int hash = getHash(key);
        int index = getKeyIndex(key, hash);
        KeyValuePair newPair = new KeyValuePair(key, value);
        if (index >= 0) {
            pairs.get(hash).set(index, newPair);
        } else {
            pairs.get(hash).add(newPair);
        }
    }

    public boolean contains(String key) {
        int hash = getHash(key);
        return getKeyIndex(key, hash) >= 0;
    }

    public T delete(String key) {
        int hash = getHash(key);
        int index = getKeyIndex(key, hash);

        if (index >= 0) {
            T value = pairs.get(hash).get(index).getValue();
            pairs.get(hash).remove(index);
            return value;
        }

        return null;
    }

    public int size() {
        int size = 0;
        for (ArrayList<KeyValuePair> hashedPairs : pairs) {
            size += hashedPairs.size();
        }

        return size;
    }

}
