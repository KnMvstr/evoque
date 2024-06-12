package com.knmvstr.evoque.kafka.ticket;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
