package com.brainstation.project.api.Model;

import com.brainstation.project.api.DTO.TransferDTO;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {

    private long id;
    private String transferNumber;
    private String transferDescription;
    private BigDecimal amount;
    private BigDecimal targetAmount;
    private Date transferDate;
    private long sourceAccountId;
    private long targetAccountId;

    public Transfer() {
        super();
    }

    public Transfer(TransferDTO transferDTO) {
        if (transferDTO != null) {
            this.id = transferDTO.getId();
            this.transferNumber = transferDTO.getTransferNumber();
            this.transferDescription = transferDTO.getTransferDescription();
            this.amount = transferDTO.getAmount();
            this.targetAmount = transferDTO.getTargetAmount();
            this.transferDate = transferDTO.getTransferDate();
            this.sourceAccountId = transferDTO.getSourceAccountId();
            this.targetAccountId = transferDTO.getTargetAccountId();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getTransferDescription() {
        return transferDescription;
    }

    public void setTransferDescription(String transferDescription) {
        this.transferDescription = transferDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
}
