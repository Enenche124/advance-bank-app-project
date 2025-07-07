package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;

public interface BankAccountService {
    BankAccount createAccountForUser(User user, AccountType accountType);
}
