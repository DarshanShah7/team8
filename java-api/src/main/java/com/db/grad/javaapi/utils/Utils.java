package com.db.grad.javaapi.utils;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {
    
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789abcdefghijklmnopqrstABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String generateUserId(int length) {
        return generateRandomString(length);
    }
    
    public String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    
    
}