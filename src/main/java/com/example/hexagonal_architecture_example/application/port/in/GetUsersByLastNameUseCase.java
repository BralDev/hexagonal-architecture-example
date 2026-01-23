package com.example.hexagonal_architecture_example.application.port.in;

import com.example.hexagonal_architecture_example.application.common.PageResult;
import com.example.hexagonal_architecture_example.application.common.SortDirection;
import com.example.hexagonal_architecture_example.application.common.UserSortField;
import com.example.hexagonal_architecture_example.application.port.out.UserRepositoryPort;
import com.example.hexagonal_architecture_example.domain.model.User;

public class GetUsersByLastNameUseCase {

    private final UserRepositoryPort userRepository;

    public GetUsersByLastNameUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public PageResult<User> execute(
        String lastName,
        int page,
        int size,
        UserSortField sortField,
        SortDirection direction) {
        UserSortField resolvedSortField = sortField != null ? sortField : UserSortField.LAST_NAME;

        SortDirection resolvedDirection = direction != null ? direction : SortDirection.ASC;

        return userRepository.findByLastNameContaining(
            lastName,
            page,
            size,
            resolvedSortField,
            resolvedDirection);
    }
}