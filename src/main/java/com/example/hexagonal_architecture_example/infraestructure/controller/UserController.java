package com.example.hexagonal_architecture_example.infraestructure.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture_example.application.port.in.CreateUserUseCase;
import com.example.hexagonal_architecture_example.application.port.in.GetUserUseCase;
import com.example.hexagonal_architecture_example.domain.model.User;
import com.example.hexagonal_architecture_example.infraestructure.controller.dto.UserReponse;
import com.example.hexagonal_architecture_example.infraestructure.controller.dto.UserRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;


    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public UserReponse createUser(@RequestBody UserRequest userRequest) {
        final User user = new User(null, userRequest.firstName(), userRequest.lastName());
        final User userCreated = createUserUseCase.createUser(user);
        return new UserReponse(userCreated.id(), userCreated.firstName(), userCreated.lastName());
    }

    @GetMapping("/{id}")
    public UserReponse getUserById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        final User user = getUserUseCase.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserReponse(user.id(), user.firstName(), user.lastName());
    }

}
