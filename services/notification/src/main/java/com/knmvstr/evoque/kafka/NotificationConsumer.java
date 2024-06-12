package com.knmvstr.evoque.kafka;

import com.knmvstr.evoque.entity.Notification;
import com.knmvstr.evoque.kafka.payment.PaymentConfirmation;
import com.knmvstr.evoque.kafka.ticket.TicketConfirmation;
import com.knmvstr.evoque.repository.NotificationRepository;
import com.knmvstr.evoque.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import static com.knmvstr.evoque.entity.NotificationType.PAYMENT_CONFIRMATION;
import static com.knmvstr.evoque.entity.NotificationType.TICKET_CONFIRMATION;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {
    //Both methods persist the data then they send an email

    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException, jakarta.mail.MessagingException {
        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.ticketReference()
        );
    }

    @KafkaListener(topics = "ticket-topic")
    public void consumeTicketConfirmationNotifications(TicketConfirmation ticketConfirmation) throws jakarta.mail.MessagingException {
        log.info(format("Consuming the message from ticket-topic Topic:: %s", ticketConfirmation));
        repository.save(
                Notification.builder()
                        .type(TICKET_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .ticketConfirmation(ticketConfirmation)
                        .build()
        );
        var customerName = ticketConfirmation.user().firstname() + " " + ticketConfirmation.user().lastname();
        emailService.sendTicketConfirmationEmail(
                ticketConfirmation.user().email(),
                customerName,
                ticketConfirmation.totalAmount(),
                ticketConfirmation.ticketReference(),
                ticketConfirmation.events()
        );
    }
}