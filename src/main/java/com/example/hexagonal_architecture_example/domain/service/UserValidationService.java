package com.example.hexagonal_architecture_example.domain.service;

import com.example.hexagonal_architecture_example.domain.model.User;

public class UserValidationService {

    public static boolean validateUser(User user){
        return user.firstName() != null && user.lastName() != null;
    }
}
