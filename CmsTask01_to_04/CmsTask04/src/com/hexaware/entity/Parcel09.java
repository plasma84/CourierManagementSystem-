package com.hexaware.entity;

public class Parcel09 {
    private String trackingNumber;
    private String status;

    public Parcel09(String trackingNumber, String status) {
        this.trackingNumber = trackingNumber;
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void trackParcel() {
        switch (status.toLowerCase()) {
            case "in transit":
                System.out.println("Parcel " + trackingNumber + " is in transit.");
                break;
            case "out for delivery":
                System.out.println("Parcel " + trackingNumber + " is out for delivery.");
                break;
            case "delivered":
                System.out.println("Parcel " + trackingNumber + " has been delivered.");
                break;
            default:
                System.out.println("Unknown status for parcel " + trackingNumber + ".");
                break;
        }
    }
}
