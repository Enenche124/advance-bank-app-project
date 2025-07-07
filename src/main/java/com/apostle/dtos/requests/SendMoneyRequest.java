package com.apostle.dtos.requests;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SendMoneyRequest {
    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
    private String note;
}
