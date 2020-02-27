package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.CreditCardDAO;
import com.brainstation.project.api.DTO.CreditCardDTO;
import com.brainstation.project.api.Model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CreditCardServiceImp")
public class CreditCardServiceImp implements CreditCardService {

    private final CreditCardDAO creditCardDAO;

    public CreditCardServiceImp(CreditCardDAO creditCardDAO) {
        this.creditCardDAO = creditCardDAO;
    }

    @Override
    public CreditCard insertCreditCard(CreditCard creditCard) {
        CreditCardDTO creditCardDTO = creditCardDAO.save(new CreditCardDTO(creditCard));
        return new CreditCard(creditCardDTO);
    }

    @Override
    public List<CreditCard> selectAllCreditCards() {
        List<CreditCardDTO> creditCardDTOS = creditCardDAO.findAll();
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardDTOS.forEach(creditCardDTO -> {
            creditCards.add(new CreditCard(creditCardDTO));
        });
        return creditCards;
    }

    @Override
    public CreditCard selectCreditCardByCardNumber(String cardNumber) {
        CreditCardDTO creditCardDTO = creditCardDAO.findByCardNumber(cardNumber);
        return new CreditCard(creditCardDTO);
    }

    @Override
    public List<CreditCard> selectAllCreditCardsByUserId(long userId) {
        List<CreditCardDTO> creditCardDTOS = creditCardDAO.findCreditCardsByUserId(userId);
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardDTOS.forEach(creditCardDTO -> {
            creditCards.add(new CreditCard(creditCardDTO));
        });
        return creditCards;
    }

    @Override
    public CreditCard updateCreditCard(long id, CreditCard creditCard) {
        CreditCardDTO creditCardDTO = new CreditCardDTO(creditCard);
        creditCardDTO.setId(id);
        creditCardDTO = creditCardDAO.save(creditCardDTO);
        return new CreditCard(creditCardDTO);
    }
}
