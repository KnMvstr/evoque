package com.knmvstr.evoque.controller.record;

import com.knmvstr.evoque.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String ticketReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}