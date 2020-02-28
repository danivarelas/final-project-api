package com.brainstation.project.api.Controller;

import com.brainstation.project.api.Model.User;
import com.brainstation.project.api.Service.UserService;
import com.brainstation.project.api.Util.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/v1/login")
@RestController
public class LoginController {

    private final UserService userService;
    private HttpServletRequest request;

    @Autowired
    public LoginController(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        User dbUser = userService.selectUserByUsername(user.getUsername());
        if (dbUser != null) {
            if (user.getPassword().equals(dbUser.getPassword())) {
                String jwt = JWTProvider.createJWT(dbUser.getId()+"", dbUser.getName(), dbUser.getUsername(), "Logged in");
                return new ResponseEntity<>(jwt, HttpStatus.OK);
            }
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Incorrect username", HttpStatus.BAD_REQUEST);
    }
}
