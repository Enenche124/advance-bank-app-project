package com.apostle.utils;

import com.apostle.data.model.BankAccount;
import com.apostle.data.model.User;
import com.apostle.dtos.requests.RegisterRequest;
import com.apostle.dtos.responses.RegisterResponses;

public class Mapper {

    public static User mapToRegisterRequest(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail().toLowerCase());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername().toLowerCase());
        return user;
    }

//    public static RegisterResponses mapToRegisterResponses() {
//        RegisterResponses registerResponses = new RegisterResponses();
//        registerResponses.setMessage("User Registration Successful");
//        registerResponses.setSuccess(true);
//        registerResponses.setAccountNumber();
//        return registerResponses;
//    }

}
