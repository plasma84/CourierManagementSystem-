package com.hexaware.entity;

import java.util.HashMap;
import java.util.Map;

public class User03 {
    public static boolean authenticate(String username, String password) {
        if (username.equals("employee1") && password.equals("password123")) {
            return true;
        } else if (username.equals("customer1") && password.equals("custpass")) {
            return true;
        }else if (username.equals("yash") && password.equals("1234")) {
            return true;
        }else {
            return false;
        }
    }
}

