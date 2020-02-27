package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.AccountDTO;

import java.math.BigDecimal;

public class Account {

    private long id;
    private String accountNumber;
    private String description;
    private String balance;
    private String currency;
    private long userId;

    public Account() {
        super();
    }

    public Account(AccountDTO accountDTO) {
        if (accountDTO != null) {
            this.id = accountDTO.getId();
            this.accountNumber = accountDTO.getAccountNumber();
            this.description = accountDTO.getDescription();
            this.balance = accountDTO.getBalance().toString();
            this.currency = accountDTO.getCurrency();
            this.userId = accountDTO.getUserId();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
