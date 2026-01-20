package com.example.hexagonal_architecture_example.application.port.in;

import com.example.hexagonal_architecture_example.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
