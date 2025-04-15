package com.cms.dao;

import com.cms.entity.Payment;
import java.util.List;

public interface PaymentDAO {
    void addPayment(Payment payment);
    Payment getPaymentById(int paymentId);
    List<Payment> getAllPayments();

    List<Payment> getPaymentsByCourierId(int courierId);
//    List<Payment> getPaymentsByLocationId(int locationId);

    void updatePayment(Payment payment);
    void deletePayment(int paymentId);
}
