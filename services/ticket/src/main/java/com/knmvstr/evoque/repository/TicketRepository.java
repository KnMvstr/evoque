package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
