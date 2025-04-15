package com.hexaware.entity;

public class AddressFormatter11 {
    public static String formatAddress(String street, String city, String state, String zipCode) {
        // Capitalizing first letter of each word in street, city, and state
        street = capitalize(street);
        city = capitalize(city);
        state = capitalize(state);

        // Ensuring zip code is in correct format (##### or #####-####)
        zipCode = zipCode.trim().replaceAll("[^0-9]", "");

        if (zipCode.length() == 5) {
            return street + ", " + city + ", " + state + " " + zipCode;
        } else if (zipCode.length() == 9) {
            return street + ", " + city + ", " + state + " " + zipCode.substring(0, 5) + "-" + zipCode.substring(5);
        } else {
            return "Invalid zip code!";
        }
    }

    // Helper method to capitalize the first letter of each word
    private static String capitalize(String text) {
        String[] words = text.split(" ");
        StringBuilder capitalizedText = new StringBuilder();

        for (String word : words) {
            capitalizedText.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return capitalizedText.toString().trim();
    }
}
