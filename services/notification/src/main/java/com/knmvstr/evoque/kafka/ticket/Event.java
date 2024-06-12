package com.knmvstr.evoque.kafka.ticket;

import java.math.BigDecimal;

public record Event(
        Long eventId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
