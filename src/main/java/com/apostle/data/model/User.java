package com.apostle.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}
