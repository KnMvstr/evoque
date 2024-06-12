package com.knmvstr.evoque.service;

import com.knmvstr.evoque.controller.record.PaymentNotificationRequest;
import com.knmvstr.evoque.controller.record.PaymentRequest;
import com.knmvstr.evoque.kafka.NotificationProducer;
import com.knmvstr.evoque.repository.PaymentRepository;
import com.knmvstr.evoque.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Long createPayment(PaymentRequest request) {

        var payment = paymentRepository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.ticketReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()

                )
        );
        return payment.getId();
    }
}