package com.cms.service.impl;

import com.cms.entity.CourierCompanyCollection;
import com.cms.entity.Employee;
import com.cms.service.ICourierAdminService;

public class CourierAdminServiceCollectionImpl extends CourierUserServiceCollectionImpl implements ICourierAdminService {

    public CourierAdminServiceCollectionImpl(CourierCompanyCollection companyObj) {
        super(companyObj);
    }

    @Override
    public int addCourierStaff(Employee obj) {
        companyObj.addEmployee(obj);
        return obj.getEmployeeId();
    }
}
