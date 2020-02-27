package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.Payment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
public class PaymentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paymentNumber;
    private String paymentDescription;
    private BigDecimal amount;
    private String currency;
    private Date paymentDate;
    private long userId;
    private long accountId;
    private long serviceId;

    public PaymentDTO() {
        super();
    }

    public PaymentDTO(Payment payment) {
        if (payment != null) {
            this.paymentNumber = payment.getPaymentNumber();
            this.paymentDescription = payment.getPaymentDescription();
            this.amount = payment.getAmount();
            this.currency = payment.getCurrency();
            this.paymentDate = payment.getPaymentDate();
            this.userId = payment.getUserId();
            this.accountId = payment.getAccountId();
            this.serviceId = payment.getServiceId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
