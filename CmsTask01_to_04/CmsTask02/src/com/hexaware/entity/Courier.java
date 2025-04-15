package com.hexaware.entity;

public class Courier {
    public String name;
    private int currentLocation;
    private int destination;

    public Courier(String name, int currentLocation, int destination) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.destination = destination;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getDestination() {
        return destination;
    }

    public void updateLocation() {
        if (currentLocation < destination) {
            currentLocation++;
        }
    }
}
