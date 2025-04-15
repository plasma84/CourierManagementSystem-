package com.cms.service;

import com.cms.entity.Courier;
import com.cms.exception.TrackingNumberNotFoundException;

import java.util.List;

public interface ICourierUserService {

    /**
     * Places a new courier order.
     *
     * @param courierObj Courier object created using user input
     * @return the generated tracking number
     */
    String placeOrder(Courier courierObj);

    /**
     * Gets the status of a courier order.
     * @param trackingNumber the tracking number
     * @return status string
     * @throws TrackingNumberNotFoundException if not found
     */
    String getOrderStatus(int trackingNumber) throws TrackingNumberNotFoundException;

    /**
     * Cancels a courier order.
     * @param trackingNumber the tracking number
     * @return true if successfully canceled, false otherwise
     * @throws TrackingNumberNotFoundException if not found
     */
    boolean cancelOrder(int trackingNumber) throws TrackingNumberNotFoundException;

    String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException;

    boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;

    /**
     * Retrieves orders assigned to a specific courier staff member.
     * @param courierStaffId the employee ID
     * @return list of courier orders
     */
    List<Courier> getAssignedOrder(int courierStaffId);

    List<Courier> getAssignedOrders(int courierStaffId);
}
