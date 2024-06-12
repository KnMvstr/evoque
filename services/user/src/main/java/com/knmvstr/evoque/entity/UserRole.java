package com.knmvstr.evoque.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum UserRole {
    USER("User role"),
    ADMIN("Administrator role"),
    STAFF("Staff role");

    private final String description;

}