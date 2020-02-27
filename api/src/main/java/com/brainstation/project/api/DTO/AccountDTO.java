package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.Account;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class AccountDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String description;
    private BigDecimal balance;
    private String currency;
    private Long userId;

    public AccountDTO(){
        super();
    }

    public AccountDTO(Account account) {
        if (account != null) {
            this.accountNumber = account.getAccountNumber();
            this.description = account.getDescription();
            this.balance = new BigDecimal(account.getBalance());
            this.currency = account.getCurrency();
            this.userId = account.getUserId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
