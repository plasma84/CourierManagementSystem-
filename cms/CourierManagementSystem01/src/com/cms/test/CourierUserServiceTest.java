package com.cms.test;

import com.cms.entity.Courier;
import com.cms.entity.CourierCompanyCollection;
import com.cms.exception.TrackingNumberNotFoundException;
import com.cms.service.ICourierUserService;
import com.cms.service.impl.CourierUserServiceCollectionImpl;

import java.util.List;

public class CourierUserServiceTest {
    public static void main(String[] args) {
        // Step 1: Create CourierCompanyCollection
        CourierCompanyCollection company = new CourierCompanyCollection();

        // Step 2: Initialize the service implementation with the company object
        ICourierUserService userService = new CourierUserServiceCollectionImpl(company);

        // Step 3: Create and place new courier orders
        Courier courier1 = new Courier(0, "John Doe", "New York", "Jane Smith", "Los Angeles", 5.5,
                "yetToTransit", "TEMP", null, 101);

        Courier courier2 = new Courier(0, "Alice Brown", "Boston", "Bob Martin", "Chicago", 2.0,
                "In Transit", "TEMP", null, 102);

        Courier courier3 = new Courier(0, "Charlie Green", "Houston", "David Lee", "Miami", 3.0,
                "yetToTransit", "TEMP", null, 101);

        Courier courier4 = new Courier(0, "Eva White", "Seattle", "Frank Black", "San Francisco", 7.2,
                "Delivered", "TEMP", null, 103);

        Courier courier5 = new Courier(0, "Grace Hall", "Austin", "Henry Ford", "Denver", 4.3,
                "yetToTransit", "TEMP", null, 102);


        userService.placeOrder(courier1);



        System.out.println("=== Test getOrderStatus ===");
        try {
            String status = userService.getOrderStatus(courier1.getTrackingNumber());
            System.out.println("Status of " + courier1.getTrackingNumber() + ": " + status);
        } catch (TrackingNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== Test cancelOrder ===");
        try {
            boolean result = userService.cancelOrder(courier1.getTrackingNumber());
            System.out.println("Cancel status of " + courier1.getTrackingNumber() + ": " + result);
        } catch (TrackingNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== Test getAssignedOrder ===");
        List<Courier> assignedTo101 = userService.getAssignedOrder(101);
        System.out.println("Orders assigned to employee ID 101:");
        for (Courier c : assignedTo101) {
            System.out.println("Tracking#: " + c.getTrackingNumber() + " | Status: " + c.getStatus());
        }

        System.out.println("=== Test Invalid Tracking Number ===");
        try {
            userService.getOrderStatus("INVALID123");
        } catch (TrackingNumberNotFoundException e) {
            System.out.println("Handled properly: " + e.getMessage());
        }
    }
}
