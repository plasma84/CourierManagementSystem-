package com.cms.dao.impl;

import com.cms.dao.PaymentDAO;
import com.cms.entity.Payment;
import com.cms.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void addPayment(Payment payment) {
        String query = "INSERT INTO Payment (CourierID, Amount, PaymentDate) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, payment.getCourierId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, Date.valueOf(payment.getPaymentDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        String query = "SELECT * FROM Payment WHERE PaymentID = ?";
        Payment payment = null;
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, paymentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                payment = extractPayment(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public List<Payment> getPaymentsByCourierId(int courierId) {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payment WHERE CourierID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courierId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payments.add(extractPayment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }



    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payment";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                payments.add(extractPayment(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public void updatePayment(Payment payment) {
        String query = "UPDATE Payment SET CourierID = ?, Amount = ?, PaymentDate = ? WHERE PaymentID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, payment.getCourierId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, Date.valueOf(payment.getPaymentDate()));
            ps.setInt(4, payment.getPaymentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int paymentId) {
        String query = "DELETE FROM Payment WHERE PaymentID = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Payment extractPayment(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("PaymentID"),
                rs.getInt("CourierID"),
                rs.getDouble("Amount"),
                rs.getDate("PaymentDate").toLocalDate()
        );
    }
}
