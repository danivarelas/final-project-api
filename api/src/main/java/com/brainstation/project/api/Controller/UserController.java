package com.brainstation.project.api.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.brainstation.project.api.Model.User;
import com.brainstation.project.api.Service.AccountService;
import com.brainstation.project.api.Service.UserService;
import com.brainstation.project.api.Util.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;
    private HttpServletRequest request;

    @Autowired
    public UserController(UserService userService, AccountService accountService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.insertUser(user) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        if (JWTProvider.validateToken(request.getHeader("JWT"))) {
            return new ResponseEntity<>(userService.selectAllUsers() , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>() , HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("byUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username) {
        return new ResponseEntity<>(userService.selectUserByUsername(username) , HttpStatus.OK);
    }

    @GetMapping("byEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(name = "email") String email) {
        return new ResponseEntity<>(userService.selectUserByEmail(email) , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

}