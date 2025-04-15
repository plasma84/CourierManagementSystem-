
package com.hexaware.client;

import com.hexaware.entity.Order;

import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        // Sample list of orders
        Order[] orders = {
                new Order("ORD001", "yash"),
                new Order("ORD002", "akash"),
                new Order("ORD003", "yash"),
                new Order("ORD004", "ram"),
                new Order("ORD006", "yash")
        };

        // Customer name to search orders for
//        String customerName = "yash";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter courier name: ");
        String customerName = scanner.nextLine();

        // Display orders for the specific customer using a for loop
        System.out.println("Orders for customer: " + customerName);
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                System.out.println("Order ID: " + order.getOrderId());
            }
        }
    }
}

