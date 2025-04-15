package com.cms.dao.impl;

import com.cms.dao.LocationDAO;
import com.cms.entity.Location;
import com.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    @Override
    public void addLocation(Location location) {
        String query = "INSERT INTO Location (LocationName, Address) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, location.getLocationName());
            ps.setString(2, location.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Location getLocationById(int locationId) {
        String query = "SELECT * FROM Location WHERE LocationID = ?";
        Location location = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, locationId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                location = extractLocation(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM Location";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                locations.add(extractLocation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public void updateLocation(Location location) {
        String query = "UPDATE Location SET LocationName = ?, Address = ? WHERE LocationID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, location.getLocationName());
            ps.setString(2, location.getAddress());
            ps.setInt(3, location.getLocationId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLocation(int locationId) {
        String query = "DELETE FROM Location WHERE LocationID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, locationId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Location extractLocation(ResultSet rs) throws SQLException {
        return new Location(
                rs.getInt("LocationID"),
                rs.getString("LocationName"),
                rs.getString("Address")
        );
    }
}
