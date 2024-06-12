package com.knmvstr.evoque.controller.record.purchase;

import java.math.BigDecimal;

public record PurchaseResponse(
        Long eventId,
        String title,
        BigDecimal price,
        Integer quantity
) {

}
