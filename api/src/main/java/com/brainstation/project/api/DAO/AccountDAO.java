package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDAO extends JpaRepository<AccountDTO, Long> {

    AccountDTO findByAccountNumber(String accountNumber);

    @Query("SELECT a FROM AccountDTO a WHERE a.userId = ?1")
    List<AccountDTO> findAccountsByUserId(long userId);

}
