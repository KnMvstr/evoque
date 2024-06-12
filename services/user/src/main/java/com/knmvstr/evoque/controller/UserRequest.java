package com.knmvstr.evoque.controller;

import com.knmvstr.evoque.entity.Address;
import com.knmvstr.evoque.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        Long id,
        @NotNull(message = "Customer firstname is required")
        String first_name,
        @NotNull(message = "Customer last_name is required")
        String last_name,
        @NotNull(message = "Customer username is required")
        String username,
        @NotNull(message = "Customer password is required")
        String password,
        @NotNull(message = "Customer role is required")
        UserRole role,
        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is not a valid email address")
        String email,
        @NotNull(message = "Customer phone is required")
        String phone,

        Address address

) {}
