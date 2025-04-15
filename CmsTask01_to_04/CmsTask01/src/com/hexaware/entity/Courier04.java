package com.hexaware.entity;

public class Courier04 {
    private String name;
    private int loadCapacity;

    public Courier04(String name, int loadCapacity) {
        this.name = name;
        this.loadCapacity = loadCapacity;
    }

    public void assignCourier(int parcelWeight) {
        if (parcelWeight <= loadCapacity) {
            System.out.println("Courier " + name + " is assigned to deliver the parcel.");
        } else {
            System.out.println("Courier " + name + " cannot take this load.");
        }
    }
}
