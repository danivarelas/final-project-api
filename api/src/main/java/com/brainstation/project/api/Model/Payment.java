package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.PaymentDTO;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {

    private long id;
    private String paymentNumber;
    private String paymentDescription;
    private BigDecimal amount;
    private String currency;
    private Date paymentDate;
    private long userId;
    private long accountId;
    private long serviceId;

    public Payment() {
        super();
    }

    public Payment(PaymentDTO paymentDTO) {
        if (paymentDTO != null) {
            this.id = paymentDTO.getId();
            this.paymentNumber = paymentDTO.getPaymentNumber();
            this.paymentDescription = paymentDTO.getPaymentDescription();
            this.amount = paymentDTO.getAmount();
            this.currency = paymentDTO.getCurrency();
            this.paymentDate = paymentDTO.getPaymentDate();
            this.userId = paymentDTO.getUserId();
            this.accountId = paymentDTO.getAccountId();
            this.serviceId = paymentDTO.getServiceId();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
