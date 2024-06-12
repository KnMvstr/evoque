package com.knmvstr.evoque.service;

import com.knmvstr.evoque.controller.record.ticketline.TicketLineRequest;
import com.knmvstr.evoque.controller.record.ticketline.TicketLineResponse;
import com.knmvstr.evoque.repository.TicketLineRepository;
import com.knmvstr.evoque.service.mapper.TicketLineMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketLineService {
    private final TicketLineRepository ticketLineRepository;
    private final TicketLineMapper ticketLineMapper;

    public Long saveTicketLine(TicketLineRequest ticketLineRequest) {
        var ticket = ticketLineMapper.toTicketLine(ticketLineRequest);
        return ticketLineRepository.save(ticket).getId();

    }

    public List<TicketLineResponse> findTicketById(Long id) {
        return ticketLineRepository.findTicketById(id)
                .stream()
                .map(ticketLineMapper::toTicketLineResponse)
                .collect(Collectors.toList());

    }
}