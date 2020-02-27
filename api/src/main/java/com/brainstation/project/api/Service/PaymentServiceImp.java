package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.PaymentDAO;
import com.brainstation.project.api.DTO.PaymentDTO;
import com.brainstation.project.api.Model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PaymentServiceImp")
public class PaymentServiceImp implements PaymentService{

    private final PaymentDAO paymentDAO;

    public PaymentServiceImp(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public Payment insertPayment(Payment payment) {
        PaymentDTO paymentDTO = paymentDAO.save(new PaymentDTO(payment));
        return new Payment(paymentDTO);
    }

    @Override
    public List<Payment> selectAllPayments() {
        List<PaymentDTO> paymentDTOS = paymentDAO.findAll();
        List<Payment> payments = new ArrayList<>();
        paymentDTOS.forEach(paymentDTO -> {
            payments.add(new Payment(paymentDTO));
        });
        return payments;
    }

    @Override
    public Payment selectPaymentByPaymentNumber(String paymentNumber) {
        PaymentDTO paymentDTO = paymentDAO.findByPaymentNumber(paymentNumber);
        return new Payment(paymentDTO);
    }

    @Override
    public List<Payment> selectAllPaymentsByUserId(long userId) {
        List<PaymentDTO> paymentDTOS = paymentDAO.findPaymentsByUserId(userId);
        List<Payment> payments = new ArrayList<>();
        paymentDTOS.forEach(paymentDTO -> {
            payments.add(new Payment(paymentDTO));
        });
        return payments;
    }

    @Override
    public Payment updatePayment(long id, Payment payment) {
        return null;
    }
}
