package com.apostle.utils;


import com.apostle.data.model.Role;

import com.apostle.data.model.User;
import com.apostle.dtos.requests.RegisterRequest;


public class Mapper {

    public static User mapToRegisterRequest(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail().toLowerCase());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername().toLowerCase());
        user.setRole(Role.USER);
        return user;
    }


}
