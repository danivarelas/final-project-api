package com.brainstation.project.api.Service;

import com.brainstation.project.api.Model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account insertAccount(Account account);

    List<Account> selectAllAccounts();

    Account selectAccountById(long id);

    Account selectAccountByAccountNumber(String accountNumber);

    List<Account> selectAllAccountsByUserId(long userId);

    Account updateAccount(long id, Account account);

    //Account deleteAccount(String accountNumber);
}
