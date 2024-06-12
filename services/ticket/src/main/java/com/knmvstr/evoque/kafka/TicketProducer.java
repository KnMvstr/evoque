package com.knmvstr.evoque.kafka;

import com.knmvstr.evoque.kafka.record.TicketConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketProducer {

    private final KafkaTemplate<String, TicketConfirmation> kafkaTemplate;

    public void sendTicketConfirmation(TicketConfirmation ticketConfirmation) {
        log.info("Sending TicketConfirmation: {}", ticketConfirmation);
        Message<TicketConfirmation> message = MessageBuilder
                .withPayload(ticketConfirmation)
                .setHeader(KafkaHeaders.TOPIC, "ticket-topic")
                .build();
        kafkaTemplate.send(message);
    }
}