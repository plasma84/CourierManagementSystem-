package com.hexaware.client;

import com.hexaware.entity.ShippingCostCalculator13;

import java.util.Scanner;

public class ShippingCostClient13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs for source, destination, and weight
        System.out.print("Enter source address: ");
        String source = scanner.nextLine();

        System.out.print("Enter destination address: ");
        String destination = scanner.nextLine();

        System.out.print("Enter parcel weight (kg): ");
        double weight = scanner.nextDouble();

        // Calculating shipping cost
        double shippingCost = ShippingCostCalculator13.calculateShippingCost(source, destination, weight);

        System.out.println("The shipping cost from " + source + " to " + destination + " for a " + weight + " kg parcel is: $" + shippingCost);

        scanner.close();
    }
}
