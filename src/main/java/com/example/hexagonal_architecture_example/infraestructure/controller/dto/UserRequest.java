package com.example.hexagonal_architecture_example.infraestructure.controller.dto;

import java.time.LocalDate;

public record UserRequest (
    String firstName,
    String lastName,
    LocalDate birthDate
){
}
