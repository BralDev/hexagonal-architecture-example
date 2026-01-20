package com.example.hexagonal_architecture_example.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture_example.application.port.in.CreateUserUseCase;
import com.example.hexagonal_architecture_example.application.port.in.GetUserUseCase;
import com.example.hexagonal_architecture_example.application.port.out.UserRepositoryPort;
import com.example.hexagonal_architecture_example.domain.model.User;
import com.example.hexagonal_architecture_example.domain.service.UserValidationService;

@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        if (!UserValidationService.validateUser(user)){
            throw new IllegalArgumentException("Invalid user data");
        }
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryPort.findById(id);
    }
}
