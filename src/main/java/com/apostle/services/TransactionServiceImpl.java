package com.apostle.services;

import com.apostle.data.model.BankAccount;
import com.apostle.data.model.Transaction;
import com.apostle.data.repositories.BankAccountRepository;
import com.apostle.data.repositories.TransactionRepo;
import com.apostle.dtos.requests.DepositRequest;
import com.apostle.dtos.requests.SendMoneyRequest;
import com.apostle.dtos.requests.WithdrawalRequest;
import com.apostle.dtos.responses.BalanceResponse;
import com.apostle.dtos.responses.TransactionResponse;
import com.apostle.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final BankAccountRepository bankAccountRepository;


    @Override
    public TransactionResponse deposit(DepositRequest request) {
        return null;
    }

    @Override
    public TransactionResponse transfer(SendMoneyRequest request) {
        return null;
    }

    @Override
    public List<TransactionResponse> getTransactionsForAccount(Long accountId) {
        return List.of();
    }

    @Override
    public TransactionResponse getTransactionById(Long transactionId) {
        return null;
    }
}
