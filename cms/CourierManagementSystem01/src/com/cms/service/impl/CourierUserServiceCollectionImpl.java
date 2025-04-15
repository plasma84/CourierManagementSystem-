package com.cms.service.impl;

import com.cms.entity.Courier;
import com.cms.entity.CourierCompanyCollection;
import com.cms.exception.TrackingNumberNotFoundException;
import com.cms.service.ICourierUserService;

import java.util.ArrayList;
import java.util.List;

public class CourierUserServiceCollectionImpl implements ICourierUserService {

    protected CourierCompanyCollection companyObj;

    public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
        this.companyObj = companyObj;
    }

    @Override
    public String placeOrder(Courier courier) {
        companyObj.getCourierList().add(courier);
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
    public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier.getStatus();
            }
        }
        throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
    }

    @Override
    public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                if (!courier.getStatus().equalsIgnoreCase("Delivered")) {
                    courier.setStatus("Cancelled");
                    return true;
                } else {
                    return false;
                }
            }
        }
        throw new TrackingNumberNotFoundException("Tracking number not found: " + trackingNumber);
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getAssignedEmployeeId() == courierStaffId) {
                assignedOrders.add(courier);
            }
        }
        return assignedOrders;
    }

    @Override
    public List<Courier> getAssignedOrders(int courierStaffId) {
        return null;
    }
}
