package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO extends JpaRepository<UserDTO, Long> {

    UserDTO findByUsername(String username);

    UserDTO findByEmail(String email);

}
