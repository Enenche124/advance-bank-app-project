package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import com.apostle.data.repositories.BankAccountRepository;
import com.apostle.data.repositories.UserRepository;
import com.apostle.dtos.requests.AddAccountRequest;
import com.apostle.dtos.responses.AddAccountResponse;
import com.apostle.exceptions.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
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
    public AddAccountResponse createAccount(AddAccountRequest addAccountRequest) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByEmail(currentUserEmail).orElseThrow(() -> new UserNotFoundException("User not found"));
        String accountNumber = generateUniqueAccountNumber();

        BankAccount account =  new BankAccount();
        account.setName(addAccountRequest.getName());
        account.setUser(user);
        account.setBalance(BigDecimal.ZERO);
        account.setAccountNumber(accountNumber);

        bankAccountRepository.save(account);

        return new AddAccountResponse(accountNumber, addAccountRequest.getName(),  BigDecimal.ZERO);
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = String.valueOf(1000000000L + new Random().nextLong(9000000000L));
        } while (bankAccountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }

}

