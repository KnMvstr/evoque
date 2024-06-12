package com.knmvstr.evoque.controller.record.ticketline;

public record TicketLineRequest(
        Long id,
        Long ticketId,
        @jakarta.validation.constraints.NotNull(message = "Event is mandatory") Integer eventId,
        Integer quantity
) {

}
