package com.knmvstr.evoque.client.payment_client;

import com.knmvstr.evoque.client.user_client.UserResponse;
import com.knmvstr.evoque.entity.ticket.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long ticketId,
        String ticketReference,
        UserResponse user
) {
}
