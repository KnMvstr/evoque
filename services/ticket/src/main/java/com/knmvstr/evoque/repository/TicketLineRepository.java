package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.controller.record.ticketline.TicketLineResponse;
import com.knmvstr.evoque.entity.ticketline.TicketLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketLineRepository extends JpaRepository<TicketLine, Long> {
    List<TicketLine> findTicketById(Long id);
}

