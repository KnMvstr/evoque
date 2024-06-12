package com.knmvstr.evoque.controller.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        Long id,
        @NotNull(message = "Firstname must be specified")
        String firstname,
        @NotNull(message = "Lastname must be specified")
        String lastname,
        @NotNull(message = "Email is required")
        @Email(message = "customer email is not correctly formatted")
        String email
) {
}
