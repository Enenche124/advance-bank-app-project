package com.apostle.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private Long transactionId;
    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private TransactionStatus status;
    private TransactionType type;
    private String note;

}
