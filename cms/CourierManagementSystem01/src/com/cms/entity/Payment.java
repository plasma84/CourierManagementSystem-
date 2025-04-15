package com.cms.entity;

import java.time.LocalDate;
import java.util.Date;

public class Payment {
    private int paymentID;
    private int courierID;
    private int locationID;
    private double amount;
    private LocalDate paymentDate;

    // Constructors
    public Payment(int paymentID, int courierID, double amount, LocalDate paymentDate) {}

    public Payment(int paymentID, int courierID, int locationID, double amount, LocalDate paymentDate) {
        this.paymentID = paymentID;
        this.courierID = courierID;
        this.locationID = locationID;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters and Setters
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getCourierId() {
        return paymentID;
    }

    public int getPaymentId() {
        return paymentID;
    }
}
