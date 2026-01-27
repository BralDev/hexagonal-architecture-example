package com.example.hexagonal_architecture_example.application.common;

import java.time.LocalDate;

import com.example.hexagonal_architecture_example.domain.model.UserStatus;

public record UserSearchFilter(
        String firstName,
        String lastName,
        UserStatus status,
        LocalDate birthDateFrom,
        LocalDate birthDateTo
) {}