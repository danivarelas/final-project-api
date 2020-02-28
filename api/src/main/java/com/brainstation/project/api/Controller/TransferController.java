package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.Account;
import com.brainstation.project.api.Model.Transfer;
import com.brainstation.project.api.Service.AccountService;
import com.brainstation.project.api.Service.TransferService;
import com.brainstation.project.api.Util.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/transfer")
@RestController
public class TransferController {

    private final TransferService transferService;
    private final AccountService accountService;
    private HttpServletRequest request;

    @Autowired
    public TransferController(TransferService transferService, AccountService accountService, HttpServletRequest request) {
        this.transferService = transferService;
        this.accountService = accountService;
        this.request = request;
    }

    @PostMapping
    public ResponseEntity<Transfer> addTransfer(@RequestBody Transfer transfer, @RequestParam(name = "buy") String buy, @RequestParam(name = "sell") String sell) {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            Account sourceAccount = accountService.selectAccountById(transfer.getSourceAccountId());
            Account targetAccount = accountService.selectAccountById(transfer.getTargetAccountId());
            BigDecimal sourceBalance = new BigDecimal(sourceAccount.getBalance());
            BigDecimal targetBalance = new BigDecimal(targetAccount.getBalance());
            BigDecimal buyRate = new BigDecimal(buy);
            BigDecimal sellRate = new BigDecimal(sell);
            if(sourceBalance.compareTo(transfer.getAmount()) >= 0) {
                if (sourceAccount.getCurrency().equals("CRC") && targetAccount.getCurrency().equals("USD")) {
                    BigDecimal newAmount = new BigDecimal(transfer.getAmount().toString());
                    newAmount = newAmount.divide(sellRate, 2 , RoundingMode.HALF_EVEN);
                    sourceAccount.setBalance(sourceBalance.subtract(transfer.getAmount()).toString());
                    transfer.setTargetAmount(newAmount);
                    targetAccount.setBalance(targetBalance.add(newAmount).toString());
                } else if (sourceAccount.getCurrency().equals("USD") && targetAccount.getCurrency().equals("CRC")) {
                    BigDecimal newAmount = new BigDecimal(transfer.getAmount().toString());
                    newAmount = newAmount.multiply(buyRate);
                    sourceAccount.setBalance(sourceBalance.subtract(transfer.getAmount()).toString());
                    transfer.setTargetAmount(newAmount);
                    targetAccount.setBalance(targetBalance.add(newAmount).toString());
                } else {
                    transfer.setTargetAmount(transfer.getAmount());
                    sourceAccount.setBalance(sourceBalance.subtract(transfer.getAmount()).toString());
                    targetAccount.setBalance(targetBalance.add(transfer.getAmount()).toString());
                }
                accountService.updateAccount(sourceAccount.getId(), sourceAccount);
                accountService.updateAccount(targetAccount.getId(), targetAccount);
                return new ResponseEntity<>(transferService.insertTransfer(transfer), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Transfer(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(new Transfer() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(transferService.selectAllTransfers() , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("byAccountId/{accountId}")
    public ResponseEntity<List<Transfer>> getAllTransfersByAccountId(@PathVariable("accountId") long accountId) {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(transferService.selectAllTransfersByAccountId(accountId) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("byTargetAccountId/{accountId}")
    public ResponseEntity<List<Transfer>> getAllTransfersByTargetAccountId(@PathVariable("accountId") long accountId) {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(transferService.selectAllTransfersByTargetAccountId(accountId) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }

}
