package com.cms.service;

import com.cms.entity.Employee;
import com.cms.exception.InvalidEmployeeIdException;

public interface ICourierAdminService {

    /**
     * Adds a new courier staff member to the system.
     * @param employee the employee object
     * @return generated employee ID
     * @throws InvalidEmployeeIdException if insertion fails due to constraint
     */
    int addCourierStaff(Employee employee) throws InvalidEmployeeIdException;
}

