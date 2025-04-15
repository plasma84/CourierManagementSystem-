package com.hexaware.client;

import com.hexaware.entity.CustomerDataValidation10;

import java.util.Scanner;

public class CustomerDataValidationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter detail (name/address/phone number): ");
        String detail = scanner.nextLine();

        System.out.print("Enter data: ");
        String data = scanner.nextLine();


        if (CustomerDataValidation10.validateData(data, detail)) {
            System.out.println("The " + detail + " is valid.");
        } else {
            System.out.println("The " + detail + " is invalid.");
        }

        scanner.close();
    }
}
