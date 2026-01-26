package com.example.hexagonal_architecture_example.infraestructure.persistence;

import org.springframework.data.jpa.domain.Specification;

import com.example.hexagonal_architecture_example.domain.model.UserStatus;

public final class UserSpecifications {

        private UserSpecifications() {
        }

        public static Specification<UserEntity> firstNameContains(String firstName) {
                return (root, query, cb) -> firstName == null
                                ? null
                                : cb.like(
                                                cb.lower(root.get("firstName")),
                                                "%" + firstName.toLowerCase() + "%");
        }

        public static Specification<UserEntity> lastNameContains(String lastName) {
                return (root, query, cb) -> lastName == null
                                ? null
                                : cb.like(
                                                cb.lower(root.get("lastName")),
                                                "%" + lastName.toLowerCase() + "%");
        }

        public static Specification<UserEntity> hasStatus(UserStatus status) {
                return (root, query, cb) -> status == null 
                                ? null 
                                : cb.equal(root.get("status"), status);
        }
}