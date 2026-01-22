package com.example.hexagonal_architecture_example.application.port.in;

import com.example.hexagonal_architecture_example.application.common.PageResult;
import com.example.hexagonal_architecture_example.application.port.out.UserRepositoryPort;
import com.example.hexagonal_architecture_example.domain.model.User;

public class GetUsersByFirstNameUseCase {

    private final UserRepositoryPort userRepository;

    public GetUsersByFirstNameUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public PageResult<User> execute(
        String firstName,
        int page,
        int size
    ) {
        return userRepository.findByFirstNameContaining(
            firstName,
            page,
            size
        );
    }
}