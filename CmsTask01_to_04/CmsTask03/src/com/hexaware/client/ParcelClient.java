// Package: client
package com.hexaware.client;

import com.hexaware.entity.Parcel;
import java.util.Scanner;

public class ParcelClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a parcel with space for 5 location updates
        Parcel parcel = new Parcel(5);

        // Taking user input for tracking updates
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter location update for tracking " + (i + 1) + ": ");
            String location = scanner.nextLine();
            parcel.updateTracking(i, location);  // Update the tracking history
        }

        // Display the tracking history
        parcel.displayTrackingHistory();

        scanner.close();
    }
}
