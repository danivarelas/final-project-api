package com.brainstation.project.api.Service;

import com.brainstation.project.api.Model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardService {

    CreditCard insertCreditCard(CreditCard creditCard);

    List<CreditCard> selectAllCreditCards();

    CreditCard selectCreditCardByCardNumber(String cardNumber);

    List<CreditCard> selectAllCreditCardsByUserId(long userId);

    CreditCard updateCreditCard(long id, CreditCard creditCard);

    //CreditCard deleteCreditCard(String cardNumber);
}
