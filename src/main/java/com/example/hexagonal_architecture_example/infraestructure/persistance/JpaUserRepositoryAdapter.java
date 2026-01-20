package com.example.hexagonal_architecture_example.infraestructure.persistance;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.hexagonal_architecture_example.application.port.out.UserRepositoryPort;
import com.example.hexagonal_architecture_example.domain.model.User;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort{

    private final SpringDateUserRepository springDataUserRepository;

    public JpaUserRepositoryAdapter(SpringDateUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.firstName(), user.lastName());
        final UserEntity savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.id(), savedUser.firstName(), savedUser.lastName());
    }

    @Override
    public Optional<User> findById(Long id) {
        final UserEntity savedUser = springDataUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return Optional.of(new User(savedUser.id(), savedUser.firstName(), savedUser.lastName()));
    }

}
