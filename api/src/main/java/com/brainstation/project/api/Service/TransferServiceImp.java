package com.brainstation.project.api.Service;

import com.brainstation.project.api.DAO.TransferDAO;
import com.brainstation.project.api.DTO.TransferDTO;
import com.brainstation.project.api.Model.Transfer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("TransferServiceImp")
public class TransferServiceImp implements TransferService {

    private final TransferDAO transferDAO;

    public TransferServiceImp(TransferDAO transferDAO) {
        this.transferDAO = transferDAO;
    }

    @Override
    public Transfer insertTransfer(Transfer transfer) {
        TransferDTO transferDTO = transferDAO.save(new TransferDTO(transfer));
        return new Transfer(transferDTO);
    }

    @Override
    public List<Transfer> selectAllTransfers() {
        List<TransferDTO> transferDTOS = transferDAO.findAll();
        List<Transfer> transfers = new ArrayList<>();
        transferDTOS.forEach(transferDTO -> {
            transfers.add(new Transfer(transferDTO));
        });
        return transfers;
    }

    @Override
    public Transfer selectTransferByTransferNumber(String transferNumber) {
        TransferDTO transferDTO = transferDAO.findByTransferNumber(transferNumber);
        return new Transfer(transferDTO);
    }

    @Override
    public List<Transfer> selectAllTransfersByAccountId(long accountId) {
        List<TransferDTO> transferDTOS = transferDAO.findTransfersByAccountId(accountId);
        List<Transfer> transfers = new ArrayList<>();
        transferDTOS.forEach(transfer -> {
            transfers.add(new Transfer(transfer));
        });
        return transfers;
    }

    @Override
    public List<Transfer> selectAllTransfersByTargetAccountId(long accountId) {
        List<TransferDTO> transferDTOS = transferDAO.findTransfersByTargetAccountId(accountId);
        List<Transfer> transfers = new ArrayList<>();
        transferDTOS.forEach(transfer -> {
            transfers.add(new Transfer(transfer));
        });
        return transfers;
    }

    @Override
    public Transfer updateTransfer(long id, Transfer transfer) {
        return null;
    }
}
