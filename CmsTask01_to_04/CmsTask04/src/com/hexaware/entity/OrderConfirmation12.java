package com.hexaware.entity;

public class OrderConfirmation12 {
    public static String generateEmail(String customerName, String orderNumber, String deliveryAddress, String deliveryDate) {
        return "Dear " + customerName + ",\n\n" +
                "Thank you for your order!\n" +
                "Your order number is: " + orderNumber + "\n" +
                "Delivery Address: " + deliveryAddress + "\n" +
                "Expected Delivery Date: " + deliveryDate + "\n\n" +
                "We hope you enjoy your purchase!\n" +
                "Best Regards,\n" +
                "Courier Service Team";
    }
}
