package com.knmvstr.evoque.kafka.record;

import com.knmvstr.evoque.client.user_client.UserResponse;
import com.knmvstr.evoque.controller.record.purchase.PurchaseResponse;
import com.knmvstr.evoque.entity.ticket.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record TicketConfirmation (
        String ticketReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        UserResponse userResponse, // Will contain the customer information to get a decent email sent
        List<PurchaseResponse> events // represent the list of the event the customer has purchased
) {
}