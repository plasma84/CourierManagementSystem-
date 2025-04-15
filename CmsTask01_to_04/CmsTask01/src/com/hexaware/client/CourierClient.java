package com.hexaware.client;

import com.hexaware.entity.Courier04;

import java.util.Scanner;

public class CourierClient {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter courier name: ");
    String courierName = scanner.nextLine();
    System.out.print("Enter courier load capacity: ");
    int loadCapacity = scanner.nextInt();
    System.out.print("Enter parcel weight for courier: ");
    int parcelWeight = scanner.nextInt();

    Courier04 courier = new Courier04(courierName, loadCapacity);
    courier.assignCourier(parcelWeight);
    scanner.close();
}
}
