// Package: entity
package com.hexaware.entity;

public class Parcel {
    private String[] trackingHistory;  // Array to store tracking updates

    public Parcel(int trackingSize) {
        // Initialize the array with a fixed size
        this.trackingHistory = new String[trackingSize];
    }

    // Method to add a location update
    public void updateTracking(int index, String location) {
        if (index >= 0 && index < trackingHistory.length) {
            trackingHistory[index] = location;
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to display the tracking history
    public void displayTrackingHistory() {
        System.out.println("Parcel Tracking History:");
        for (String location : trackingHistory) {
            if (location != null) {
                System.out.println(location);
            }
        }
    }
}

