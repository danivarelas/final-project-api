package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.CreditCard;
import com.brainstation.project.api.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/creditCard")
@RestController
public class CreditCardController {

    private final CreditCardService creditCardService;
    private HttpServletRequest request;

    @Autowired
    public CreditCardController(CreditCardService creditCardService, HttpServletRequest request) {
        this.creditCardService = creditCardService;
        this.request = request;
    }

    @PostMapping
    public void addCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.insertCreditCard(creditCard);
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
        return new ResponseEntity<>(creditCardService.selectAllCreditCards() , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

    @GetMapping("byUserId/{userId}")
    public ResponseEntity<List<CreditCard>> getAllCreditCardsByUserId(@PathVariable("userId") long userId) {
        //if (JWTProvider.validateToken(request.getHeader("JWT"))) {
        return new ResponseEntity<>(creditCardService.selectAllCreditCardsByUserId(userId) , HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        //}
    }

    @GetMapping("{accountNumber}")
    public CreditCard getCreditCardByCardNumber(@PathVariable("cardNumber") String cardNumber) {
        return creditCardService.selectCreditCardByCardNumber(cardNumber);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody CreditCard creditCard) {
        creditCardService.updateCreditCard(id, creditCard);
    }
}
