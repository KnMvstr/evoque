package com.knmvstr.evoque.entity;

import com.knmvstr.evoque.kafka.payment.PaymentConfirmation;
import com.knmvstr.evoque.kafka.ticket.TicketConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Notification {

    @Id
    private Long id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private TicketConfirmation ticketConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
