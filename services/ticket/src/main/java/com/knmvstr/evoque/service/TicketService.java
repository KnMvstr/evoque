package com.knmvstr.evoque.service;

import com.knmvstr.evoque.client.event_client.EventClient;
import com.knmvstr.evoque.client.payment_client.PaymentClient;
import com.knmvstr.evoque.client.payment_client.PaymentRequest;
import com.knmvstr.evoque.controller.record.purchase.PurchaseRequest;
import com.knmvstr.evoque.controller.record.ticketline.TicketLineRequest;
import com.knmvstr.evoque.controller.record.ticket.TicketRequest;
import com.knmvstr.evoque.client.user_client.UserClient;
import com.knmvstr.evoque.controller.record.ticket.TicketResponse;
import com.knmvstr.evoque.custom_response.BusinessException;
import com.knmvstr.evoque.kafka.TicketProducer;
import com.knmvstr.evoque.kafka.record.TicketConfirmation;
import com.knmvstr.evoque.repository.TicketRepository;
import com.knmvstr.evoque.service.mapper.TicketMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketLineService ticketLineService;
    private final TicketRepository ticketRepository;
    private final EventClient eventClient;
    private final UserClient userClient;
    private final TicketMapper mapper;
    private final TicketProducer ticketProducer;
    private final PaymentClient paymentClient;

    @Transactional
    public Long createTicket(TicketRequest request) {
        //Check if we have a customer-->(Openfeign)
        var user = this.userClient.findUserById(request.userId())
                .orElseThrow(() -> new BusinessException("Cannot ticket : No Customer with ID : " + request.userId()));
        //Purchasing the event using event microservice ->(RestTemplate method for example)
        var purchaseEvents = this.eventClient.purchaseEvents(request.events());
        //Persist Ticket to Ticket Lines
        var ticket = this.ticketRepository.save(mapper.toTicket(request));
        for (PurchaseRequest purchaseRequest : request.events()) {
            ticketLineService.saveTicketLine(
                    new TicketLineRequest(
                            null,
                            ticket.getId(),
                            purchaseRequest.eventId(),
                            purchaseRequest.quantity()
                    ));
        }
        var paymentRequest = new PaymentRequest(
                request.totalAmount(),
                request.paymentMethod(),
                ticket.getId(),
                ticket.getReference(),
                user

        );
        paymentClient.requestTicketPayment(paymentRequest);

        //Send the confirmation  to our notification microservice-->(Kafka)
        ticketProducer.sendTicketConfirmation(
                new TicketConfirmation(
                        request.reference(),
                        request.totalAmount(),
                        request.paymentMethod(),
                        user,
                        purchaseEvents
                )
        );
        return ticket.getId();
    }

    public List<TicketResponse> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(mapper::fromTicket)
                .collect(Collectors.toList());
    }

    public TicketResponse findById(Long id) {
        return ticketRepository.findById(id)
                .map(mapper::fromTicket)
                .orElseThrow(() -> new BusinessException("Cannot find any ticket : No Customer with ID : " + id));
    }

    // Start payment process

}
