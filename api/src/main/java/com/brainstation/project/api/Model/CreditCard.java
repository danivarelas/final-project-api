package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.CreditCardDTO;

import java.math.BigDecimal;
import java.util.Date;

public class CreditCard {

    private long id;
    private String cardNumber;
    private BigDecimal cardLimit;
    private String currency;
    private BigDecimal balance;
    private Date paymentDate;
    private long userId;

    public CreditCard() {
        super();
    }

    public CreditCard(CreditCardDTO creditCardDTO) {
        if (creditCardDTO != null) {
            this.id = creditCardDTO.getId();
            this.cardNumber = creditCardDTO.getCardNumber();
            this.cardLimit = creditCardDTO.getCardLimit();
            this.currency = creditCardDTO.getCurrency();
            this.balance = creditCardDTO.getBalance();
            this.paymentDate = creditCardDTO.getPaymentDate();
            this.userId = creditCardDTO.getUserId();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(BigDecimal cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
