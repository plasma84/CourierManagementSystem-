package com.cms.dao;

import com.cms.entity.CourierService;
import java.util.List;

public interface CourierServiceDAO {
    void addService(CourierService service);
    CourierService getServiceById(int serviceId);
    List<CourierService> getAllServices();
    void updateService(CourierService service);
    void deleteService(int serviceId);
}
