package com.knmvstr.evoque.service.mapper;

import com.knmvstr.evoque.controller.record.ticket.TicketRequest;
import com.knmvstr.evoque.controller.record.ticket.TicketResponse;
import com.knmvstr.evoque.entity.ticket.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketMapper {

    public Ticket toTicket(TicketRequest request) {
        return Ticket.builder()
                .id(request.id())
                .userId(request.userId())
                .reference(request.reference())
                .totalAmount(request.totalAmount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public TicketResponse fromTicket(Ticket ticket) {
        return  new TicketResponse(
                ticket.getId(),
                ticket.getReference(),
                ticket.getTotalAmount(),
                ticket.getPaymentMethod(),
                ticket.getUserId()
        );
    }
}
