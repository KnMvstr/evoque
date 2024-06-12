package com.knmvstr.evoque.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventRequest(
        Long id,
        @NotNull(message = "Event title is required")
        String title,

        @NotNull(message = "Event description is required")
        String description,

        String image,
        @NotNull(message = "Event beginning is required")
        LocalDateTime startTime,
        @NotNull(message = "Event ending is required")
        LocalDateTime endTime,
        @NotNull(message = "Event category is required")
        Integer categoryId,
        @Positive(message = "Price must be positive ")
        BigDecimal price,
        @Positive(message = "Available quantity must be positive ")
        Integer availableQtty
) {
}