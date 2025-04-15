package com.cms.service.impl;

import com.cms.entity.Courier;
import com.cms.entity.CourierCompany;
import com.cms.exception.TrackingNumberNotFoundException;
import com.cms.service.ICourierUserService;

import java.util.ArrayList;
import java.util.List;

public class CourierUserServiceImpl implements ICourierUserService {

    protected CourierCompany companyObj;

    public CourierUserServiceImpl(CourierCompany companyObj) {
        this.companyObj = companyObj;
    }

    @Override
    public String placeOrder(Courier courier) {
        companyObj.addCourier(courier);
        return courier.getTrackingNumber();
    }

    @Override
    public String getOrderStatus(int trackingNumber) throws TrackingNumberNotFoundException {
        return null;
    }

    @Override
    public boolean cancelOrder(int trackingNumber) throws TrackingNumberNotFoundException {
        return false;
    }

    @Override
    public String getOrderStatus(String trackingNumber) {
        Courier[] couriers = companyObj.getCouriers();
        for (Courier c : couriers) {
            if (c != null && c.getTrackingNumber().equals(trackingNumber)) {
                return c.getStatus();
            }
        }
        return "Tracking Number Not Found!";
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        Courier[] couriers = companyObj.getCouriers();
        for (Courier c : couriers) {
            if (c != null && c.getTrackingNumber().equals(trackingNumber)) {
                c.setStatus("Cancelled");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
        List<Courier> result = new ArrayList<>();
        for (Courier c : companyObj.getCouriers()) {
            if (c != null && c.getAssignedEmployeeId() == courierStaffId) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public List<Courier> getAssignedOrders(int courierStaffId) {
        return null;
    }
}
