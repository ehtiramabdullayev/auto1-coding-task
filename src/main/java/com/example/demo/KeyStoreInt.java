package com.example.demo;

public interface KeyStoreInt {
    String storeKey(String key, String value);
    String storeKey(int key, String value);
    String storeKey(String value);
    String returnValue(String key);
    String returnValue(int key);
    int getElementSize();
}
