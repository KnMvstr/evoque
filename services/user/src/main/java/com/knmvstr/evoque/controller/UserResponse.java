package com.knmvstr.evoque.controller;

import com.knmvstr.evoque.entity.Address;
import com.knmvstr.evoque.entity.UserRole;


public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String username,
        String password,
        UserRole role,
        String email,
        String phone,
        Address address
) {
}
