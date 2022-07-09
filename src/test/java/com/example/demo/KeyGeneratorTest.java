package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class KeyGeneratorTest {
    KeyGenerator keyGenerator;

    @BeforeEach
    void setUp() {
        keyGenerator = new KeyGenerator();
    }

    @Test
    @RepeatedTest(5)
    void checkIfKeyGenerationSuccess() {
        System.out.println(keyGenerator.generateKey());
    }

}