package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.Account;
import com.brainstation.project.api.Model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private int countryCode;
    private int phoneNumber;

    public UserDTO() {
        super();
    }

    public UserDTO(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserDTO(User user) {
        if (user != null) {
            this.name = user.getName();
            this.lastName = user.getLastName();
            this.email = user.getEmail();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.countryCode = user.getCountryCode();
            this.phoneNumber = user.getPhoneNumber();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int country_code) {
        this.countryCode = country_code;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phone_number) {
        this.phoneNumber = phone_number;
    }
}
