package com.apostle.services;

import com.apostle.data.model.User;
import com.apostle.data.repositories.UserRepository;
import com.apostle.dtos.requests.LoginRequest;
import com.apostle.dtos.requests.RegisterRequest;
import com.apostle.dtos.responses.LoginResponse;
import com.apostle.dtos.responses.RegisterResponses;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;



@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private Validator validator;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }


    @Override
    public RegisterResponses register(RegisterRequest registerRequest) {
        String inputPassword = registerRequest.getPassword();

        boolean emailExists = userRepository.findUserByEmail(registerRequest.getEmail()).isPresent();
        if (emailExists){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(inputPassword);
        user.setUsername(registerRequest.getUsername());
        userRepository.save(user);
        RegisterResponses registerResponses = new RegisterResponses();
        registerResponses.setMessage("User registered successfully");
        registerResponses.setSuccess(true);
        return registerResponses;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}
