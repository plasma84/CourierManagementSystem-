package com.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {

    public static Connection getConnection() {
        Connection connection = null;
        try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("❌ Sorry, unable to find db.properties");
                return null;
            }

            // Load properties file
            prop.load(input);

            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            // Load JDBC driver
            Class.forName(driver);

            // Establish and return new connection
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            System.err.println("❌ Database connection failed: " + ex.getMessage());
            ex.printStackTrace();
        }
        return connection;
    }
}
