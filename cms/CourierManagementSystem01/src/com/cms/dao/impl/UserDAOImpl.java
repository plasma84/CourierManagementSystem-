package com.cms.dao.impl;

import com.cms.dao.UserDAO;
import com.cms.entity.User;
import com.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user) {
        String query = "INSERT INTO User (Name, Email, Password, ContactNumber, Address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getContactNumber());
            ps.setString(5, user.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int userId) {
        String query = "SELECT * FROM User WHERE UserID = ?";
        User user = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM User WHERE Email = ?";
        User user = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE User SET Name = ?, Email = ?, Password = ?, ContactNumber = ?, Address = ? WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getContactNumber());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String query = "DELETE FROM User WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("UserID"),
                rs.getString("Name"),
                rs.getString("Email"),
                rs.getString("Password"),
                rs.getString("ContactNumber"),
                rs.getString("Address")
        );
    }
}
