package com.hexaware.client;

import java.util.Scanner;
import com.hexaware.entity.Parcel02;

public class ParcelClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parcel weight: ");
        double weight = scanner.nextDouble();
        Parcel02 parcel = new Parcel02(weight);
        parcel.categorizeParcel();
        scanner.close();
    }
}
