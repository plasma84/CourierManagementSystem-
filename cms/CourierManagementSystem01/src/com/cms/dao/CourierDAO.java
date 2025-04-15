package com.cms.dao;

import com.cms.entity.Courier;
import java.util.List;

public interface CourierDAO {
    void addCourier(Courier courier);
    Courier getCourierById(int courierId);
    Courier getCourierByTrackingNumber(String trackingNumber);
    List<Courier> getAllCouriers();
    void updateCourier(Courier courier);
    void deleteCourier(int courierId);
    List<Courier> getCouriersByStatus(String status);
}
