package com.hallbookingmanagement.mapper;

import com.hallbookingmanagement.beans.Payment;
import java.util.List;

public interface PaymentMapper {
    
    List<Payment> getAllPayments();

    int insertPayment(Payment payment);

    Payment selectPaymentById(int paymentId);

    int updatePayment(Payment payment);

    int deletePayment(int paymentId);
}
