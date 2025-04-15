package com.hexaware.client;

import com.hexaware.entity.User03;

import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (User03.authenticate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
        scanner.close();
    }
}
