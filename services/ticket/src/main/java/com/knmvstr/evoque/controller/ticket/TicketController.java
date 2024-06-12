package com.knmvstr.evoque.controller.ticket;

import com.knmvstr.evoque.controller.record.ticket.TicketRequest;
import com.knmvstr.evoque.controller.record.ticket.TicketResponse;
import com.knmvstr.evoque.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<Long> createTicket(@RequestBody @Valid TicketRequest request) {
        return ResponseEntity.ok(ticketService.createTicket(request));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> findAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));

    }
}
