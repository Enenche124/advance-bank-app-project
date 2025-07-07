package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    @Override
    public BankAccount createAccountForUser(User user, AccountType accountType) {
        return null;
    }
}
