package com.knmvstr.evoque.service.mapper;

import com.knmvstr.evoque.controller.record.ticketline.TicketLineRequest;
import com.knmvstr.evoque.controller.record.ticketline.TicketLineResponse;
import com.knmvstr.evoque.entity.ticket.Ticket;
import com.knmvstr.evoque.entity.ticketline.TicketLine;
import org.springframework.stereotype.Service;

@Service
public class TicketLineMapper {
    public TicketLine toTicketLine(TicketLineRequest request) {
        return TicketLine.builder()
                .id(request.ticketId())
                .quantity(request.quantity())
                .eventId(request.eventId())
                .ticket(
                        Ticket.builder()
                                .id(request.id())
                                .build()
                )
                .build();
    }

    public TicketLineResponse toTicketLineResponse(TicketLine ticketLine) {
        return new TicketLineResponse(ticketLine.getId(), ticketLine.getQuantity());
    }
}
