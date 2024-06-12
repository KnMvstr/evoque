package com.knmvstr.evoque.controller.record;

import com.knmvstr.evoque.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest (
        Long id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long ticketId,
        String ticketReference,
        Customer customer
) {
}
