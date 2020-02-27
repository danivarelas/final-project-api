package com.brainstation.project.api.Service;

import com.brainstation.project.api.Model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    Payment insertPayment(Payment payment);

    List<Payment> selectAllPayments();

    Payment selectPaymentByPaymentNumber(String paymentNumber);

    List<Payment> selectAllPaymentsByUserId(long userId);

    Payment updatePayment(long id, Payment payment);

    //Payment deletePayment(String paymentNumber);
}
