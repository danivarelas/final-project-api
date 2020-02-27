package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.UserDTO;

import java.util.List;

public class User {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private int countryCode;
    private int phoneNumber;

    public User() {
        super();
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(UserDTO userDTO) {
        if(userDTO != null) {
            this.id = userDTO.getId();
            this.name = userDTO.getName();
            this.lastName = userDTO.getLastName();
            this.email = userDTO.getEmail();
            this.username = userDTO.getUsername();
            this.password = userDTO.getPassword();
            this.countryCode = userDTO.getCountryCode();
            this.phoneNumber = userDTO.getPhoneNumber();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}