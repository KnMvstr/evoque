package com.knmvstr.evoque.kafka.ticket;

import com.knmvstr.evoque.kafka.payment.PaymentMethod;
import java.math.BigDecimal;
import java.util.List;

public record TicketConfirmation(
        String ticketReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer user,
        List<Event> events
) {
}