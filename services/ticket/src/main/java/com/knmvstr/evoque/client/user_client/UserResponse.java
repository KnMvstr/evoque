package com.knmvstr.evoque.client.user_client;

public record UserResponse (
        Long id,
        String first_name,
        String last_name,
        String username,
        String email
){
}