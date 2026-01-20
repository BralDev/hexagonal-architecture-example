package com.example.hexagonal_architecture_example.infraestructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDateUserRepository extends JpaRepository<UserEntity, Long>{

}
