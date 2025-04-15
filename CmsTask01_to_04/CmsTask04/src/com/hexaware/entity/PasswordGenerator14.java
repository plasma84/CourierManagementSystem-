package com.hexaware.entity;

import java.security.SecureRandom;

public class PasswordGenerator14 {
    public static String generatePassword() {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?";

        String allChars = upperCaseChars + lowerCaseChars + numbers + specialChars;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        // Ensuring at least one character from each category
        password.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length())));
        password.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Filling the rest of the password length (8 characters in this case)
        for (int i = 4; i < 8; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }
}
