// Package: entity
package com.hexaware.entity;

public class Courier {
    private String name;
    private int distance;  // Assume distance is measured in some unit (e.g., kilometers)

    // Constructor
    public Courier(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
