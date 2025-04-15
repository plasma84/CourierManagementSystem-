package com.hexaware.client;

import com.hexaware.entity.Order01;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter order status (Processing/Delivered/Cancelled): ");
        String status = scanner.nextLine();
        Order01 order = new Order01(status);
        order.checkStatus();
        scanner.close();
    }
}
