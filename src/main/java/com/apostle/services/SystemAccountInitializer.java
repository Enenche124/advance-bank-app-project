package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.repositories.BankAccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class SystemAccountInitializer {
    private final BankAccountRepository bankAccountRepository;

    @PostConstruct
    public void createSystemAccountIfNotExists() {
        Long systemId = 0L;
        if(!bankAccountRepository.existsById(systemId)) {
            BankAccount systemAccount = BankAccount.builder()
                    .id(systemId)
                    .accountNumber("SYSTEM")
                    .balance(BigDecimal.ZERO)
                    .accountType(AccountType.SYSTEM)
                    .user(null)
                    .build();
            bankAccountRepository.save(systemAccount);

        }
    }

}
