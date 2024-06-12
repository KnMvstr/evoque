package com.knmvstr.evoque.controller;

import jakarta.validation.constraints.NotNull;

public record EventPurchaseResquest(
        @NotNull(message = "Event is mandatory")
        Long eventId,
        @NotNull(message = "Quantity is mandatory")
        double eventQtty
) {
}