package demo.knmvstr.evoque.service;

import demo.knmvstr.evoque.entity.Ticket;
import demo.knmvstr.evoque.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl {
    @Autowired
    private TicketRepository ticketRepository;
}
