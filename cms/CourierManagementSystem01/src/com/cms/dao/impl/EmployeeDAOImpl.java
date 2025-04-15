package com.cms.dao.impl;

import com.cms.dao.EmployeeDAO;
import com.cms.entity.Employee;
import com.cms.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (Name, Email, ContactNumber, Role, Salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getContactNumber());
            ps.setString(4, employee.getRole());
            ps.setDouble(5, employee.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        String query = "SELECT * FROM Employee WHERE EmployeeID = ?";
        Employee employee = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = extractEmployee(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(extractEmployee(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET Name = ?, Email = ?, ContactNumber = ?, Role = ?, Salary = ? WHERE EmployeeID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getContactNumber());
            ps.setString(4, employee.getRole());
            ps.setDouble(5, employee.getSalary());
            ps.setInt(6, employee.getEmployeeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM Employee WHERE EmployeeID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Employee extractEmployee(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("EmployeeID"),
                rs.getString("Name"),
                rs.getString("Email"),
                rs.getString("ContactNumber"),
                rs.getString("Role"),
                rs.getDouble("Salary")
        );
    }
}
