package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.AccountDAO;
import com.brainstation.project.api.DTO.AccountDTO;
import com.brainstation.project.api.Model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AccountServiceImp")
public class AccountServiceImp implements AccountService {

    private final AccountDAO accountDAO;

    public AccountServiceImp(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account insertAccount(Account account) {
        AccountDTO accountDTO = accountDAO.save( new AccountDTO(account));
        return new Account(accountDTO);
    }

    public List<Account> selectAllAccounts() {
        List<AccountDTO> accountsDTO = accountDAO.findAll();
        List<Account> accounts = new ArrayList<>();
        accountsDTO.forEach(accountDTO -> {
            accounts.add(new Account(accountDTO));
        });
        return accounts;
    }

    public Account selectAccountById(long id) {
        AccountDTO accountDTO = accountDAO.findById(id).get();
        return new Account(accountDTO);
    }

    public Account selectAccountByAccountNumber(String accountNumber) {
        AccountDTO accountDTO = accountDAO.findByAccountNumber(accountNumber);
        return new Account(accountDTO);
    }

    public List<Account> selectAllAccountsByUserId(long userId) {
        List<AccountDTO> accountsDTO = accountDAO.findAccountsByUserId(userId);
        List<Account> accounts = new ArrayList<>();
        accountsDTO.forEach(accountDTO -> {
            accounts.add(new Account(accountDTO));
        });
        return accounts;
    }

    public Account updateAccount(long id, Account account) {
        AccountDTO accountDTO = new AccountDTO(account);
        accountDTO.setId(id);
        accountDTO = accountDAO.save(accountDTO);
        return new Account(accountDTO);
    }

}
