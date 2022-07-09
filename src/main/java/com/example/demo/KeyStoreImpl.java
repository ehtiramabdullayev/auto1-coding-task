package com.example.demo;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class KeyStoreImpl implements KeyStoreInt {
    private final Map<String, String> keyStorage = new ConcurrentHashMap<>();

    @Override
    public String storeKey(String key, String value) {
        if (key == null || value == null || key.length() > 20) throw new IllegalArgumentException("Invalid Args");
        keyStorage.put(key.toLowerCase(Locale.ROOT), value);
        return key;
    }

    @Override
    public String returnValue(String key) {
        if (key == null) throw new IllegalArgumentException("Invalid Args");
        return keyStorage.get(key.toLowerCase(Locale.ROOT));
    }

    @Override
    public String storeKey(int key, String value) {
        return storeKey(String.valueOf(key), value);
    }

    @Override
    public String returnValue(int key) {
        return returnValue(String.valueOf(key));
    }

    public int getElementSize() {
        return keyStorage.size();
    }

    @Override
    public String storeKey(String value) {
        return null;
    }
}
