package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KeyStoreImplTest {
    private KeyStoreInt keyStoreInt;

    @BeforeEach
    void setUp() {
        keyStoreInt = new KeyStoreImpl();
    }

    @DisplayName("check if null passed as key when storing fails")
    @Test
    void whenPassedNullAsKeyStoreKeyShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> keyStoreInt.storeKey(null, "value"));
    }

    @DisplayName("check if null passed as value when storing fails")
    @Test
    void whenPassedNullAsKeyStoreValueShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> keyStoreInt.storeKey("", null));
    }

    @DisplayName("check if null passed as key when key is longer than 20  fails")
    @Test
    void whenPassedMoreLengthThanTwentyAsKeyStoreKeyShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> keyStoreInt.storeKey("qwertyopewrwerqerwiqruewqewqrrwer", "value"));
    }

    @DisplayName("check succeess")
    @Test
    void whenStoreKeyShouldSuccess() {
        Assertions.assertEquals("key", keyStoreInt.storeKey("key", "value"));
    }

    @DisplayName("check succeess")
    @Test
    void whenRetrieveKeyShouldSuccess() {
        keyStoreInt.storeKey("key", "value");
        keyStoreInt.storeKey("KEY", "value");
        Assertions.assertEquals("value", keyStoreInt.returnValue("KEY"));
        Assertions.assertEquals(1, keyStoreInt.getElementSize());
    }

    @DisplayName("check fails")
    @Test
    void whenRetrieveKeyShouldFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> keyStoreInt.returnValue(null));
    }

    @DisplayName("check success")
    @Test
    void whenStoreKeyWithIntShouldSuccess() {
        Assertions.assertEquals("255", keyStoreInt.storeKey(255, "a"));
    }

    @DisplayName("check success")
    @Test
    void whenRetrieveKeyWithIntShouldSuccess() {
        keyStoreInt.storeKey(255, "value");

        Assertions.assertEquals("value", keyStoreInt.returnValue(255));
    }
}