package com.cms.test;

import com.cms.entity.CourierCompany;
import com.cms.entity.Employee;
import com.cms.service.impl.CourierAdminServiceImpl;

public class TestCourierAdminServiceImpl {
    public static void main(String[] args) {
        CourierCompany company = new CourierCompany();
        CourierAdminServiceImpl adminService = new CourierAdminServiceImpl(company);

        // Create and add a new employee
        Employee emp = new Employee(201, "Ravi Kumar", "ravi.kumar@example.com", "1234567890", "Courier Staff", 35000.0);
        int empId = adminService.addCourierStaff(emp);
        System.out.println("Added Employee ID: " + empId);
    }
}
