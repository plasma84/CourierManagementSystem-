package com.cms.test;

import com.cms.entity.Courier;
import com.cms.entity.CourierCompanyCollection;
import com.cms.entity.Employee;
import com.cms.exception.TrackingNumberNotFoundException;
import com.cms.service.impl.CourierAdminServiceCollectionImpl;

public class TestCourierAdminServiceCollectionImpl {
    public static void main(String[] args) throws TrackingNumberNotFoundException {
        CourierCompanyCollection company = new CourierCompanyCollection();
        CourierAdminServiceCollectionImpl adminService = new CourierAdminServiceCollectionImpl(company);

        // Add new employee
        Employee emp = new Employee(301, "Sneha Sharma", "sneha.sharma@example.com", "9876543210", "Courier Staff", 42000.0);
        int id = adminService.addCourierStaff(emp);
        System.out.println("Employee added with ID: " + id);

        // Place courier using inherited method
        Courier courier = new Courier(0, "Arun", "Delhi", "Kiran", "Mumbai", 5.0, "yetToTransit", "TEMP", null, 301);
        String tracking = adminService.placeOrder(courier);
        System.out.println("Courier placed with tracking number: " + tracking);

        // Check status
        System.out.println("Status: " + adminService.getOrderStatus(tracking));
    }
}
