package com.cms.dao;

import com.cms.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
