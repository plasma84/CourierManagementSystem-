package com.cms.main;

import com.cms.dao.UserDAO;
import com.cms.dao.impl.UserDAOImpl;
import com.cms.entity.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestUserDAOImpl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAOImpl();
        int choice = -1;

        while (choice != 0) {
            try {
                System.out.println("\n====== Courier Management - User Menu ======");
                System.out.println("1. Add New User");
                System.out.println("2. Get User by ID");
                System.out.println("3. Get User by Email");
                System.out.println("4. Update User");
                System.out.println("5. Delete User");
                System.out.println("6. List All Users");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter Password: ");
                            String password = scanner.nextLine();
                            System.out.print("Enter Contact Number: ");
                            String contact = scanner.nextLine();
                            System.out.print("Enter Address: ");
                            String address = scanner.nextLine();

                            User newUser = new User(0, name, email, password, contact, address);
                            userDAO.addUser(newUser);
                            System.out.println("✅ User added successfully.");
                        } catch (Exception e) {
                            System.out.println("❌ Error while adding user: " + e.getMessage());
                        }
                    }

                    case 2 -> {
                        try {
                            System.out.print("Enter User ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            User user = userDAO.getUserById(id);
                            if (user != null) {
                                System.out.println("👤 User Found: " + user.getName() + " - " + user.getEmail());
                            } else {
                                System.out.println("⚠️ User not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error while fetching user: " + e.getMessage());
                            scanner.nextLine(); // Clear buffer
                        }
                    }

                    case 3 -> {
                        try {
                            System.out.print("Enter Email: ");
                            String email = scanner.nextLine();
                            User user = userDAO.getUserByEmail(email);
                            if (user != null) {
                                System.out.println("👤 User Found: " + user.getName() + " - " + user.getEmail());
                            } else {
                                System.out.println("⚠️ User not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error while fetching user by email: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        try {
                            System.out.print("Enter User ID to Update: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            User user = userDAO.getUserById(id);
                            if (user != null) {
                                System.out.print("Enter New Name (" + user.getName() + "): ");
                                user.setName(scanner.nextLine());

                                System.out.print("Enter New Email (" + user.getEmail() + "): ");
                                user.setEmail(scanner.nextLine());

                                System.out.print("Enter New Password: ");
                                user.setPassword(scanner.nextLine());

                                System.out.print("Enter New Contact (" + user.getContactNumber() + "): ");
                                user.setContactNumber(scanner.nextLine());

                                System.out.print("Enter New Address (" + user.getAddress() + "): ");
                                user.setAddress(scanner.nextLine());

                                userDAO.updateUser(user);
                                System.out.println("✅ User updated.");
                            } else {
                                System.out.println("⚠️ User not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error while updating user: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }

                    case 5 -> {
                        try {
                            System.out.print("Enter User ID to delete: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            User user = userDAO.getUserById(id);
                            if (user != null) {
                                userDAO.deleteUser(id);
                                System.out.println("🗑️ User deleted.");
                            } else {
                                System.out.println("⚠️ User not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error while deleting user: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }

                    case 6 -> {
                        try {
                            List<User> users = userDAO.getAllUsers();
                            if (users.isEmpty()) {
                                System.out.println("⚠️ No users found.");
                            } else {
                                System.out.println("📋 List of All Users:");
                                for (User u : users) {
                                    System.out.println(u.getUserId() + " | " + u.getName() + " | " + u.getEmail() + " | " + u.getContactNumber());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error while listing users: " + e.getMessage());
                        }
                    }

                    case 0 -> System.out.println("👋 Exiting User Management.");
                    default -> System.out.println("❌ Invalid choice. Try again.");
                }

            } catch (InputMismatchException ime) {
                System.out.println("⚠️ Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("❌ Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
