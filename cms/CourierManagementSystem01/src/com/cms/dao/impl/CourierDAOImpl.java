package com.cms.dao.impl;

import com.cms.dao.CourierDAO;
import com.cms.entity.Courier;
import com.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourierDAOImpl implements CourierDAO {

    @Override
    public void addCourier(Courier courier) {
        String query = "INSERT INTO Courier (SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, courier.getSenderName());
            ps.setString(2, courier.getSenderAddress());
            ps.setString(3, courier.getReceiverName());
            ps.setString(4, courier.getReceiverAddress());
            ps.setDouble(5, courier.getWeight());
            ps.setString(6, courier.getStatus());
            ps.setString(7, courier.getTrackingNumber());
            ps.setDate(8, Date.valueOf(courier.getDeliveryDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Courier getCourierById(int courierId) {
        String query = "SELECT * FROM Courier WHERE CourierID = ?";
        Courier courier = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courierId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                courier = extractCourier(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courier;
    }

    @Override
    public Courier getCourierByTrackingNumber(String trackingNumber) {
        String query = "SELECT * FROM Courier WHERE TrackingNumber = ?";
        Courier courier = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, trackingNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                courier = extractCourier(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courier;
    }

    @Override
    public List<Courier> getAllCouriers() {
        List<Courier> list = new ArrayList<>();
        String query = "SELECT * FROM Courier";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(extractCourier(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateCourier(Courier courier) {
        String query = "UPDATE Courier SET SenderName=?, SenderAddress=?, ReceiverName=?, ReceiverAddress=?, Weight=?, Status=?, TrackingNumber=?, DeliveryDate=? WHERE CourierID=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, courier.getSenderName());
            ps.setString(2, courier.getSenderAddress());
            ps.setString(3, courier.getReceiverName());
            ps.setString(4, courier.getReceiverAddress());
            ps.setDouble(5, courier.getWeight());
            ps.setString(6, courier.getStatus());
            ps.setString(7, courier.getTrackingNumber());
            ps.setDate(8, Date.valueOf(courier.getDeliveryDate()));
            ps.setInt(9, courier.getCourierId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourier(int courierId) {
        String query = "DELETE FROM Courier WHERE CourierID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courierId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Courier> getCouriersByStatus(String status) {
        List<Courier> list = new ArrayList<>();
        String query = "SELECT * FROM Courier WHERE Status = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractCourier(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Courier extractCourier(ResultSet rs) throws SQLException {
        return new Courier(
                rs.getInt("CourierID"),
                rs.getString("SenderName"),
                rs.getString("SenderAddress"),
                rs.getString("ReceiverName"),
                rs.getString("ReceiverAddress"),
                rs.getDouble("Weight"),
                rs.getString("Status"),
                rs.getString("TrackingNumber"),
                rs.getDate("DeliveryDate").toLocalDate(),
                rs.getInt("AssignedEmployeeId")
        );
    }
}
