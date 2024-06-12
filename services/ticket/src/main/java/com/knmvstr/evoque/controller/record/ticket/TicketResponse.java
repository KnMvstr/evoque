package com.knmvstr.evoque.controller.record.ticket;

import com.knmvstr.evoque.entity.ticket.PaymentMethod;

import java.math.BigDecimal;

public record TicketResponse(
        Long id,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String userId
) {
}
