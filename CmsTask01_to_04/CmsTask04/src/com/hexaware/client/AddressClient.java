package com.hexaware.client;

import com.hexaware.entity.AddressFormatter11;

import java.util.Scanner;

public class AddressClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for address
        System.out.print("Enter street address: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip code: ");
        String zipCode = scanner.nextLine();

        // Formatting the address
        String formattedAddress = AddressFormatter11.formatAddress(street, city, state, zipCode);
        System.out.println("Formatted Address: " + formattedAddress);

        scanner.close();
    }
}
