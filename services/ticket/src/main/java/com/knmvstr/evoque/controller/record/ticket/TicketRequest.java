package com.knmvstr.evoque.controller.record.ticket;

import com.knmvstr.evoque.controller.record.purchase.PurchaseRequest;
import com.knmvstr.evoque.entity.ticket.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record TicketRequest(
        Long id,
        String reference,

        @Positive(message = "Ticket amount must be positive")
        BigDecimal totalAmount,

        @NotNull(message = "Payment should be precised")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String userId,

        @NotEmpty(message = "You should at least purchase one event")
        List<PurchaseRequest> events
) {
}
