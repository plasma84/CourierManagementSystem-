package com.cms.test;

import com.cms.entity.Courier;
import com.cms.entity.CourierCompany;
import com.cms.service.impl.CourierUserServiceImpl;

public class TestCourierUserServiceImpl {
    public static void main(String[] args) {
        CourierCompany company = new CourierCompany();
        CourierUserServiceImpl userService = new CourierUserServiceImpl(company);

        // Place an order
        Courier courier = new Courier(0, "Sender A", "City A", "Receiver B", "City B", 4.0, "yetToTransit", "TEMP", null, 101);
        String trackingNumber = userService.placeOrder(courier);
        System.out.println("Tracking Number: " + trackingNumber);

        // Check order status
        String status = userService.getOrderStatus(trackingNumber);
        System.out.println("Order Status: " + status);

        // Cancel the order
        boolean canceled = userService.cancelOrder(trackingNumber);
        System.out.println("Order canceled? " + canceled);
    }
}
