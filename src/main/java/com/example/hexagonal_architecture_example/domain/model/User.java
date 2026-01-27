package com.example.hexagonal_architecture_example.domain.model;

import java.time.LocalDate;

public record User (
    Long id,
    String firstName,
    String lastName,
    UserStatus status,    
    LocalDate birthDate
){
}
