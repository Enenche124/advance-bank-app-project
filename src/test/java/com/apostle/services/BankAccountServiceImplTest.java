package com.apostle.services;

import com.apostle.data.model.AccountType;
import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import com.apostle.data.repositories.UserRepository;
import com.apostle.dtos.requests.RegisterRequest;
import com.apostle.dtos.responses.RegisterResponses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountServiceImplTest {

    @Autowired
    private BankAccountServiceImpl bankAccountService;

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserRepository userRepository;

    private RegisterRequest createRegisterRequest(String email, String username, String password) {
        RegisterRequest request = new RegisterRequest();
        request.setEmail(email);
        request.setUsername(username);
        request.setPassword(password);
        return request;
    }

    @Test
    public void testAccountCreation_works(){
        RegisterRequest request = createRegisterRequest("john.doe1@example.com", "johndoe", "Password@2024");
        RegisterResponses registerResponses = authenticationService.register(request);
        assertNotNull(registerResponses);
        assertTrue(registerResponses.isSuccess());

        User user = userRepository.findUserByEmail(request.getEmail()).get();

        BankAccount account = bankAccountService.createAccountForUser(user, AccountType.SAVINGS);
        assertNotNull(account);
        assertEquals(user, account.getUser());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
        assertNotNull(account.getAccountNumber());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(10, account.getAccountNumber().length());

    }

}