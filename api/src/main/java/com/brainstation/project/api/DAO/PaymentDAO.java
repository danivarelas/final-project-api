package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.PaymentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentDAO extends JpaRepository<PaymentDTO, Long> {

    PaymentDTO findByPaymentNumber(String paymentNumber);

    @Query("SELECT p FROM PaymentDTO p WHERE p.userId = ?1")
    List<PaymentDTO> findPaymentsByUserId(long userId);
}
