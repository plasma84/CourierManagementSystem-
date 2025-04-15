package com.hexaware.client;

import java.util.Scanner;
import com.hexaware.entity.OrderConfirmation12;

public class OrderClient12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter order number: ");
        String orderNumber = scanner.nextLine();
        System.out.print("Enter delivery address: ");
        String deliveryAddress = scanner.nextLine();
        System.out.print("Enter expected delivery date: ");
        String deliveryDate = scanner.nextLine();

        // Generating email
        String email = OrderConfirmation12.generateEmail(customerName, orderNumber, deliveryAddress, deliveryDate);
        System.out.println("\nOrder Confirmation Email:\n");
        System.out.println(email);

        scanner.close();
    }
}
