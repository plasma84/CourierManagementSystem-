package com.cms.service.impl;

import com.cms.entity.CourierCompany;
import com.cms.entity.Employee;
import com.cms.service.ICourierAdminService;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {

    public CourierAdminServiceImpl(CourierCompany companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(Employee obj) {
        companyObj.addEmployee(obj);
        return obj.getEmployeeId();
    }
}
