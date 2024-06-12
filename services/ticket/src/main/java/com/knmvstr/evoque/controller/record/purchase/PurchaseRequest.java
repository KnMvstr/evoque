package com.knmvstr.evoque.controller.record.purchase;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Event is mandatory")
        Integer eventId,

        @Positive(message = "Quantity is mandatory")
        Integer quantity
) {

}
