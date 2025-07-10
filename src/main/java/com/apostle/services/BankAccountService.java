package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import com.apostle.dtos.requests.AddAccountRequest;
import com.apostle.dtos.responses.AddAccountResponse;

import java.math.BigDecimal;

public interface BankAccountService {
    BankAccount createAccountForUser(User user, AccountType accountType);
    AddAccountResponse createAccount(AddAccountRequest addAccountRequest);
    BigDecimal getBalance(Long accountId);
    void credit(Long accountId, BigDecimal amount);
    void debit(Long accountId, BigDecimal amount);
    BankAccount getAccountById(Long accountId);
}
