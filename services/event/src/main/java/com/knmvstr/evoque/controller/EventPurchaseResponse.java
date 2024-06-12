package com.knmvstr.evoque.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventPurchaseResponse(
        Long id, String title,
        String description,
        String image,
        double availableQtty,
        LocalDateTime endTime,
        LocalDateTime startTime,
        BigDecimal price
) {
}