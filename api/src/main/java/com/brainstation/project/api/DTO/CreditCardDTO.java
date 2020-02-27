package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.CreditCard;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardNumber;
    private BigDecimal cardLimit;
    private String currency;
    private BigDecimal balance;
    private Date paymentDate;
    private Long userId;

    public CreditCardDTO() {
        super();
    }

    public CreditCardDTO(CreditCard creditCard) {
        if (creditCard != null) {
            this.cardNumber = creditCard.getCardNumber();
            this.cardLimit = creditCard.getCardLimit();
            this.currency = creditCard.getCurrency();
            this.balance = creditCard.getBalance();
            this.paymentDate = creditCard.getPaymentDate();
            this.userId = creditCard.getUserId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
