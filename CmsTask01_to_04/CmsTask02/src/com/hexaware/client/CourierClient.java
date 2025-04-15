
package com.hexaware.client;

import com.hexaware.entity.Courier;

public class CourierClient {
    public static void main(String[] args) {
        // Create a courier with initial location 0 and destination 10
        Courier courier = new Courier("Courier A", 0, 10);

        // Track the courier until it reaches the destination using a while loop
        System.out.println("Tracking Courier: " + courier.name);
        while (courier.getCurrentLocation() < courier.getDestination()) {
            System.out.println("Courier's current location: " + courier.getCurrentLocation());
            courier.updateLocation(); // Update the location
        }
        System.out.println("Courier has reached the destination!");
    }
}
