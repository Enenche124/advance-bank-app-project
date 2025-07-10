package com.apostle.dtos.responses;

import java.math.BigDecimal;

public record BalanceResponse(
        Long accountId,
        BigDecimal balance
) { }
