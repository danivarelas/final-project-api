package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.CreditCardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CreditCardDAO extends JpaRepository<CreditCardDTO, Long> {

    CreditCardDTO findByCardNumber(String cardNumber);

    @Query("SELECT cc FROM CreditCardDTO cc WHERE cc.userId = ?1")
    List<CreditCardDTO> findCreditCardsByUserId(long userId);
}
