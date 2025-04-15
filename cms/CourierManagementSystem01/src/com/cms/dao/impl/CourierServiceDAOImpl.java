package com.cms.dao.impl;

import com.cms.dao.CourierServiceDAO;
import com.cms.entity.CourierService;
import com.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourierServiceDAOImpl implements CourierServiceDAO {

    @Override
    public void addService(CourierService service) {
        String query = "INSERT INTO CourierServices (ServiceName, Cost) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourierService getServiceById(int serviceId) {
        String query = "SELECT * FROM CourierServices WHERE ServiceID = ?";
        CourierService service = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, serviceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                service = new CourierService(rs.getInt("ServiceID"), rs.getString("ServiceName"), rs.getDouble("Cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<CourierService> getAllServices() {
        List<CourierService> list = new ArrayList<>();
        String query = "SELECT * FROM CourierServices";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new CourierService(rs.getInt("ServiceID"), rs.getString("ServiceName"), rs.getDouble("Cost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateService(CourierService service) {
        String query = "UPDATE CourierServices SET ServiceName = ?, Cost = ? WHERE ServiceID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getCost());
            ps.setInt(3, service.getServiceId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(int serviceId) {
        String query = "DELETE FROM CourierServices WHERE ServiceID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, serviceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
