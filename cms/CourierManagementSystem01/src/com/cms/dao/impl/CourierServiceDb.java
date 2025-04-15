package com.cms.dao.impl;

import com.cms.entity.Courier;
import com.cms.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourierServiceDb {

    private static Connection connection;

    // Initialize static connection
    static {
        try {
            connection = DBUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert a new courier order
    public static void insertCourier(Courier courier) {
        String sql = "INSERT INTO Courier (SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate, AssignedEmployeeId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, courier.getSenderName());
            ps.setString(2, courier.getSenderAddress());
            ps.setString(3, courier.getReceiverName());
            ps.setString(4, courier.getReceiverAddress());
            ps.setDouble(5, courier.getWeight());
            ps.setString(6, courier.getStatus());
            ps.setString(7, courier.getTrackingNumber());
            ps.setDate(8, courier.getDeliveryDate() != null ? Date.valueOf(courier.getDeliveryDate()) : null);
            ps.setInt(9, courier.getAssignedEmployeeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update courier status
    public static boolean updateCourierStatus(String trackingNumber, String newStatus) {
        String sql = "UPDATE Courier SET Status = ? WHERE TrackingNumber = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setString(2, trackingNumber);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve delivery history by tracking number
    public static Courier getCourierByTrackingNumber(String trackingNumber) {
        String sql = "SELECT * FROM Courier WHERE TrackingNumber = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractCourier(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Shipment status report (all courier statuses)
    public static List<Courier> getAllCourierStatusReport() {
        List<Courier> couriers = new ArrayList<>();
        String sql = "SELECT * FROM Courier";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                couriers.add(extractCourier(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couriers;
    }

    // Revenue report (sum of all payments)
    public static double getTotalRevenue() {
        String sql = "SELECT SUM(Amount) as total FROM Payment";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    // Helper method to extract Courier object
    private static Courier extractCourier(ResultSet rs) throws SQLException {
        return new Courier(
                rs.getInt("CourierID"),
                rs.getString("SenderName"),
                rs.getString("SenderAddress"),
                rs.getString("ReceiverName"),
                rs.getString("ReceiverAddress"),
                rs.getDouble("Weight"),
                rs.getString("Status"),
                rs.getString("TrackingNumber"),
                rs.getDate("DeliveryDate") != null ? rs.getDate("DeliveryDate").toLocalDate() : null,
                rs.getInt("AssignedEmployeeId")
        );
    }
}
