package com.example.demo;

import java.util.Random;

public class KeyGenerator {

    public String generateKey() {
        String a_Z = "abcdqertyuiopasdhfjlgQTWSADNYBQWUNQWEVTASD762340912341";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int i1 = new Random().nextInt(a_Z.length());
            builder.append(a_Z.charAt(i1));
        }
        return builder.toString();
    }
}
