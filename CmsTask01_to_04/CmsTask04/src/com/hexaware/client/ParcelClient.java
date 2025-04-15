package com.hexaware.client;

import com.hexaware.entity.Parcel09;
import java.util.Scanner;

public class ParcelClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] parcelTrackingData = {
                {"123", "in transit"},
                {"456", "out for delivery"},
                {"789", "delivered"}
        };

        System.out.print("Enter tracking number: ");
        String trackingNumber = scanner.nextLine();

        boolean found = false;
        for (String[] parcel : parcelTrackingData) {
            if (parcel[0].equals(trackingNumber)) {
                Parcel09 parcelObj = new Parcel09(parcel[0], parcel[1]);
                parcelObj.trackParcel();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Tracking number not found.");
        }

        scanner.close();
    }
}
