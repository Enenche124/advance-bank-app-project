package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import com.apostle.data.repositories.BankAccountRepository;
import com.apostle.exceptions.InsufficientBalanceException;
import com.apostle.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount createAccountForUser(User user, AccountType accountType) {
        String accountNumber = generateUniqueAccountNumber();

        BankAccount account = BankAccount.builder()
                .accountNumber(accountNumber)
                .balance(BigDecimal.ZERO)
                .accountType(accountType)
                .user(user)
                .build();

        return bankAccountRepository.save(account);
    }

    @Override
    public BigDecimal getBalance(Long accountId) {
        return getAccountById(accountId).getBalance();
    }

    @Override
    @Transactional
    public void credit(Long accountId, BigDecimal amount) {
        BankAccount account = getAccountById(accountId);
        if(account.getBalance().compareTo(amount) <= 0) {
            throw new InsufficientBalanceException("amount cannot be less than 0");
        }
        account.setBalance(account.getBalance().add(amount));
        bankAccountRepository.save(account);

    }

    @Override
    @Transactional
    public void debit(Long accountId, BigDecimal amount) {
        BankAccount account = getAccountById(accountId);
        if(account.getBalance().compareTo(amount) <= 0) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        account.setBalance(account.getBalance().add(amount));
        bankAccountRepository.save(account);
    }

    @Override
    public BankAccount getAccountById(Long accountId) {
        return bankAccountRepository.findById(accountId).orElseThrow(() -> new UserNotFoundException("Account not found"));
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = String.valueOf(1000000000L + new Random().nextLong(9000000000L));
        } while (bankAccountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }
}

