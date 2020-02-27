package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.UserDAO;
import com.brainstation.project.api.DTO.UserDTO;
import com.brainstation.project.api.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserServiceImp")
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User insertUser(User user) {
        UserDTO userDTO = userDAO.save(new UserDTO(user));
        return new User(userDTO);
    }

    public List<User> selectAllUsers() {
        List<UserDTO> userDTOS = userDAO.findAll();
        List<User> users = new ArrayList<>();
        userDTOS.forEach(userDTO -> {
            users.add(new User(userDTO));
        });
        return users;
    }

    public User selectUserByUsername(String username) {
        UserDTO userDTO = userDAO.findByUsername(username);
        return new User(userDTO);
    }

    public User selectUserByEmail(String email) {
        UserDTO userDTO = userDAO.findByEmail(email);
        return new User(userDTO);
    }

    public User updateUser(long id, User user) {
        UserDTO userDTO = new UserDTO(user);
        userDTO.setId(id);
        userDTO = userDAO.save(userDTO);
        return new User(userDTO);
    }

    /*public int deleteUser(String username) {
        return userDao.deleteUser(username);
    }*/

}