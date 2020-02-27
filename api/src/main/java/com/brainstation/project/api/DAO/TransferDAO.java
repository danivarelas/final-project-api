package com.brainstation.project.api.DAO;

import com.brainstation.project.api.DTO.TransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransferDAO extends JpaRepository<TransferDTO, Long> {

    TransferDTO findByTransferNumber(String transferNumber);

    @Query("SELECT t FROM TransferDTO t WHERE t.sourceAccountId = ?1")
    List<TransferDTO> findTransfersByAccountId(long sourceAccountId);

    @Query("SELECT t FROM TransferDTO t WHERE t.targetAccountId = ?1")
    List<TransferDTO> findTransfersByTargetAccountId(long targetAccountId);
}
