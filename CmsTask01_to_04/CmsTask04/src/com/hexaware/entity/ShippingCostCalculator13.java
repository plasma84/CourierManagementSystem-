package com.hexaware.entity;

public class ShippingCostCalculator13 {
    public static double calculateShippingCost(String source, String destination, double weight) {
        // Base cost for handling the parcel
        double baseCost = 5.0;

        // Distance factor - assuming some predefined distances for simplicity
        double distanceFactor = getDistanceFactor(source, destination);

        // Weight factor - assuming a simple cost per kg
        double weightFactor = weight * 0.5;  // For example, 0.5 per kg

        // Total shipping cost
        double totalCost = baseCost + distanceFactor + weightFactor;
        return totalCost;
    }

    // Helper method to determine distance factor
    private static double getDistanceFactor(String source, String destination) {
        // Simple logic based on predefined source and destination locations
        // In a real-world scenario, we might use coordinates or an API to calculate the distance
        if (source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("mumbai")) {
            return 15.0;  // Arbitrary distance factor
        } else if (source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("chennai")) {
            return 10.0;
        } else {
            return 8.0;  // Default distance factor
        }
    }
}
