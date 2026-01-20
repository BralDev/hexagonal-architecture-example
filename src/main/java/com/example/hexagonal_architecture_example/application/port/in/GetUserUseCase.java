package com.example.hexagonal_architecture_example.application.port.in;

import java.util.Optional;

import com.example.hexagonal_architecture_example.domain.model.User;

public interface GetUserUseCase {
    Optional<User> findById(Long id);
}
