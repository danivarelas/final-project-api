package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.Account;
import com.brainstation.project.api.Model.Payment;
import com.brainstation.project.api.Model.Transfer;
import com.brainstation.project.api.Service.AccountService;
import com.brainstation.project.api.Service.PaymentService;
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
@RequestMapping("/api/v1/payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;
    private final AccountService accountService;
    private HttpServletRequest request;

    @Autowired
    public PaymentController(PaymentService paymentService, AccountService accountService, HttpServletRequest request) {
        this.paymentService = paymentService;
        this.accountService = accountService;
        this.request = request;
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            Account account = accountService.selectAccountById(payment.getAccountId());
            BigDecimal balance = new BigDecimal(account.getBalance());
            if(balance.compareTo(payment.getAmount()) >= 0) {
                account.setBalance(balance.subtract(payment.getAmount()).toString());
                accountService.updateAccount(account.getId(), account);
                return new ResponseEntity<>(paymentService.insertPayment(payment), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Payment(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(new Payment() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(paymentService.selectAllPayments() , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("byUserId/{userId}")
    public ResponseEntity<List<Payment>> getAllPaymentsByUserId(@PathVariable("userId") long userId) {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(paymentService.selectAllPaymentsByUserId(userId) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }
}
