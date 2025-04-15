package com.hexaware.entity;

public class Order01 {private String status;

    public Order01(String status) {
        this.status = status;
    }

    public void checkStatus() {
        if (status.equalsIgnoreCase("Delivered")) {
            System.out.println("Order has been delivered.");
        } else if (status.equalsIgnoreCase("Processing")) {
            System.out.println("Order is still being processed.");
        } else if (status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Order has been cancelled.");
        } else {
            System.out.println("Unknown order status.");
        }
    }
}
