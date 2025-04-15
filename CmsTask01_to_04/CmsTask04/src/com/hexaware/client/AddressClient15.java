package com.hexaware.client;

import com.hexaware.entity.AddressSimilarityFinder15;

import java.util.Scanner;

public class AddressClient15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for two addresses
        System.out.print("Enter first address: ");
        String address1 = scanner.nextLine();
        System.out.print("Enter second address: ");
        String address2 = scanner.nextLine();

        // Checking if the addresses are similar
        boolean similar = AddressSimilarityFinder15.areAddressesSimilar(address1, address2);
        if (similar) {
            System.out.println("The addresses are similar.");
        } else {
            System.out.println("The addresses are different.");
        }

        scanner.close();
    }
}
