package com.knmvstr.evoque.controller.ticketline;

import com.knmvstr.evoque.controller.record.ticketline.TicketLineResponse;
import com.knmvstr.evoque.service.TicketLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket_lines")
@RequiredArgsConstructor
public class TicketLineController {

    private final TicketLineService ticketLineService;

    @GetMapping("/ticket/{id}")
    public ResponseEntity <List<TicketLineResponse>> findTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketLineService.findTicketById(id));
    }

}
