package com.brainstation.project.api.Service;

import java.util.List;

import com.brainstation.project.api.Model.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User insertUser(User user);

    List<User> selectAllUsers();

    User selectUserByUsername(String username);

    User selectUserByEmail(String email);

    User updateUser(long id, User user);

    /*int deleteUser(String username);*/

}