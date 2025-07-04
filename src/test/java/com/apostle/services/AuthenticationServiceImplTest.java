package com.apostle.services;


import com.apostle.data.repositories.UserRepository;
import com.apostle.dtos.requests.RegisterRequest;
import com.apostle.dtos.responses.RegisterResponses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthenticationServiceImplTest {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();

    }

    @Test
    public void testRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("example@gmail.com");
        registerRequest.setPassword("Password@2002");
        registerRequest.setUsername("user_name");


        RegisterResponses registerResponses = authenticationService.register(registerRequest);
        assertNotNull(registerResponses);
        assertEquals("User registered successfully", registerResponses.getMessage());
        assertTrue(registerResponses.isSuccess());
    }

}