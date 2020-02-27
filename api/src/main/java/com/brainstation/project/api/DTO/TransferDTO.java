package com.brainstation.project.api.DTO;

import com.brainstation.project.api.Model.Transfer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transfer")
public class TransferDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String transferNumber;
    private String transferDescription;
    private BigDecimal amount;
    private BigDecimal targetAmount;
    private Date transferDate;
    private Long sourceAccountId;
    private Long targetAccountId;

    public TransferDTO() {
        super();
    }

    public TransferDTO(Transfer transfer) {
        if (transfer != null) {
            this.transferNumber = transfer.getTransferNumber();
            this.transferDescription = transfer.getTransferDescription();
            this.amount = transfer.getAmount();
            this.targetAmount = transfer.getTargetAmount();
            this.transferDate = transfer.getTransferDate();
            this.sourceAccountId = transfer.getSourceAccountId();
            this.targetAccountId = transfer.getTargetAccountId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
}
