package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.Account;
import com.brainstation.project.api.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;
    private HttpServletRequest request;

    @Autowired
    public AccountController(AccountService accountService, HttpServletRequest request) {
        this.accountService = accountService;
        this.request = request;
    }

    @PostMapping
    public void addAccount(@RequestBody Account account) {
        accountService.insertAccount(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(accountService.selectAllAccounts() , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

    @GetMapping("byUserId/{userId}")
    public ResponseEntity<List<Account>> getAllAccountsByUserId(@PathVariable("userId") long userId) {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
        return new ResponseEntity<>(accountService.selectAllAccountsByUserId(userId) , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

    @GetMapping("{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountService.selectAccountByAccountNumber(accountNumber);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody Account account) {
        accountService.updateAccount(id, account);
    }

}
