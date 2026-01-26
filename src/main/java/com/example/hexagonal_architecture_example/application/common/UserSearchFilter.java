package com.example.hexagonal_architecture_example.application.common;

import com.example.hexagonal_architecture_example.domain.model.UserStatus;

public record UserSearchFilter(
        String firstName,
        String lastName,
        UserStatus status
) {}