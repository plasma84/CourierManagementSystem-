package com.hexaware.entity;

public class AddressSimilarityFinder15 {
    public static boolean areAddressesSimilar(String address1, String address2) {
        // Normalize the addresses by converting to lowercase and removing spaces
        address1 = address1.replaceAll("\\s", "").toLowerCase();
        address2 = address2.replaceAll("\\s", "").toLowerCase();

        return address1.equals(address2);
    }
}
