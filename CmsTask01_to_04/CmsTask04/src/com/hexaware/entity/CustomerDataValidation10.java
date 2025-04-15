package com.hexaware.entity;

import java.util.regex.Pattern;

public class CustomerDataValidation10 {



        public static boolean validateData(String data, String detail) {
            if (detail.equalsIgnoreCase("name")) {
                // Validate name: Only letters and capitalized
                return data.matches("^[A-Z][a-zA-Z]*$");
            } else if (detail.equalsIgnoreCase("address")) {
                // Validate address: No special characters
                return !data.matches("^[a-zA-Z0-9\\s,.-]*$");
            } else if (detail.equalsIgnoreCase("phone number")) {
                // Validate phone number format (###-###-####)
                return Pattern.matches("\\d{10}", data);
            }
            return false;
        }
    }


