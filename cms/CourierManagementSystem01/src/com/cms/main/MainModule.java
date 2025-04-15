package com.cms.main;

import com.cms.dao.impl.CourierServiceDb;
import com.cms.entity.Courier;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("=== 📦 Courier Management System ===");

        while (choice != 0) {
            try {
                System.out.println("\n========== Main Menu ==========");
                System.out.println("1. Insert New Courier");
                System.out.println("2. Update Courier Status");
                System.out.println("3. Get Courier by Tracking Number");
                System.out.println("4. View Shipment Status Report");
                System.out.println("5. View Total Revenue");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Enter Sender Name: ");
                            String senderName = scanner.nextLine();
                            System.out.print("Enter Sender Location: ");
                            String senderLocation = scanner.nextLine();
                            System.out.print("Enter Receiver Name: ");
                            String receiverName = scanner.nextLine();
                            System.out.print("Enter Receiver Location: ");
                            String receiverLocation = scanner.nextLine();
                            System.out.print("Enter Weight (kg): ");
                            double weight = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            System.out.print("Enter Status (e.g., yetToTransit, In Transit, Delivered): ");
                            String status = scanner.nextLine();
                            System.out.print("Enter Tracking Number: ");
                            String trackingNumber = scanner.nextLine();
                            System.out.print("Enter Delivery Days from Today: ");
                            int days = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Assigned Employee ID: ");
                            int empId = scanner.nextInt();
                            scanner.nextLine();

                            LocalDate estDeliveryDate = LocalDate.now().plusDays(days);
                            Courier courier = new Courier(0, senderName, senderLocation, receiverName,
                                    receiverLocation, weight, status, trackingNumber, estDeliveryDate, empId);
                            CourierServiceDb.insertCourier(courier);
                            System.out.println("✅ Courier inserted successfully.");
                        } catch (Exception e) {
                            System.out.println("❌ Error inserting courier: " + e.getMessage());
                            scanner.nextLine(); // clear buffer
                        }
                    }

                    case 2 -> {
                        try {
                            System.out.print("Enter Tracking Number: ");
                            String trackingNumber = scanner.nextLine();
                            System.out.print("Enter New Status: ");
                            String newStatus = scanner.nextLine();
                            boolean updated = CourierServiceDb.updateCourierStatus(trackingNumber, newStatus);
                            if (updated) {
                                System.out.println("✅ Status updated successfully.");
                            } else {
                                System.out.println("⚠️ Failed to update status. Check tracking number.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error updating status: " + e.getMessage());
                        }
                    }

                    case 3 -> {
                        try {
                            System.out.print("Enter Tracking Number: ");
                            String trackingNumber = scanner.nextLine();
                            Courier c = CourierServiceDb.getCourierByTrackingNumber(trackingNumber);

                            if (c != null) {
                                System.out.println("📦 Courier Details:");
                                System.out.println("Sender: " + c.getSenderName() + " → " + c.getSenderAddress());
                                System.out.println("Receiver: " + c.getReceiverName() + " → " + c.getReceiverAddress());
                                System.out.println("Weight: " + c.getWeight() + " kg");
                                System.out.println("Status: " + c.getStatus());
                                System.out.println("Tracking #: " + c.getTrackingNumber());
                                System.out.println("Estimated Delivery Date: " + c.getDeliveryDate());
                                System.out.println("Assigned Employee ID: " + c.getAssignedEmployeeId());
                            } else {
                                System.out.println("⚠️ Courier not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error fetching courier: " + e.getMessage());
                        }
                    }



                    case 4 -> {
                        try {
                            System.out.println("\n=== 📋 Shipment Status Report ===");
                            List<Courier> couriers = CourierServiceDb.getAllCourierStatusReport();
                            if (couriers.isEmpty()) {
                                System.out.println("⚠️ No couriers found.");
                            } else {
                                for (Courier c : couriers) {
                                    System.out.println("[" + c.getTrackingNumber() + "] " +
                                            c.getSenderName() + " → " + c.getReceiverName() +
                                            " | Status: " + c.getStatus() +
                                            " | Employee ID: " + c.getAssignedEmployeeId());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error fetching shipment report: " + e.getMessage());
                        }
                    }

                    case 5 -> {
                        try {
                            System.out.println("💰 Calculating total revenue...");
                            double totalRevenue = CourierServiceDb.getTotalRevenue();
                            System.out.println("Total Revenue (₹): " + totalRevenue);
                        } catch (Exception e) {
                            System.out.println("❌ Error calculating revenue: " + e.getMessage());
                        }
                    }

                    case 0 -> System.out.println("👋 Exiting Courier Management System. Goodbye!");

                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }

            } catch (InputMismatchException ime) {
                System.out.println("⚠️ Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("❌ Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
