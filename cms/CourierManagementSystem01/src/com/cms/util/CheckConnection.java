package com.cms.util;

import java.sql.Connection;

public class CheckConnection {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();

        if (connection != null) {
            System.out.println("✅ Database connection successful!");
        } else {
            System.out.println("❌ Failed to connect to the database.");
        }
    }
}
