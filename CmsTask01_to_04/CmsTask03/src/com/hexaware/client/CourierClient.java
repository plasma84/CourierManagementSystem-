// Package: client
package com.hexaware.client;

import com.hexaware.entity.Courier;
import java.util.Scanner;

public class CourierClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of couriers with name and distance
        Courier[] couriers = {
                new Courier("Courier A", 10),  // Distance 10 km
                new Courier("Courier B", 5),   // Distance 5 km
                new Courier("Courier C", 15)   // Distance 15 km
        };

        // Taking user input for the order's required distance (where the package needs to go)
        System.out.print("Enter the order's required distance (in km): ");
        int orderDistance = scanner.nextInt();

        // Find the nearest courier
        Courier nearestCourier = findNearestCourier(couriers, orderDistance);

        // Output the nearest courier
        if (nearestCourier != null) {
            System.out.println("The nearest available courier is: " + nearestCourier.getName());
        } else {
            System.out.println("No available couriers.");
        }

        scanner.close();
    }

    // Method to find the nearest courier based on the order's required distance
    public static Courier findNearestCourier(Courier[] couriers, int orderDistance) {
        Courier nearestCourier = null;
        int minDifference = Integer.MAX_VALUE;

        // Find the courier with the smallest difference in distance from the order's required distance
        for (Courier courier : couriers) {
            int distanceDifference = Math.abs(courier.getDistance() - orderDistance); // Calculate difference
            if (distanceDifference < minDifference) {
                minDifference = distanceDifference;
                nearestCourier = courier;
            }
        }

        return nearestCourier;
    }
}
