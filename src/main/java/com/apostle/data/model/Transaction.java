package com.apostle.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 16)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 16)
    private TransactionType type;

    @Column(length = 255)
    private String note;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
