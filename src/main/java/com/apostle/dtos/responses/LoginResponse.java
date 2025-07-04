package com.apostle.dtos.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private String message;
    private boolean success;
}
