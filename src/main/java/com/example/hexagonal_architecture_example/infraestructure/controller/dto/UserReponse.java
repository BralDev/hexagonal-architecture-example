package com.example.hexagonal_architecture_example.infraestructure.controller.dto;

import com.example.hexagonal_architecture_example.domain.model.UserStatus;

public record UserReponse (
    Long id,
    String firstName,
    String lastName,
    UserStatus status
){
}