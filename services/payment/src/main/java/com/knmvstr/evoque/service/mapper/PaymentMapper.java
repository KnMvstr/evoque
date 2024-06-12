package com.knmvstr.evoque.service.mapper;

import com.knmvstr.evoque.controller.record.PaymentRequest;
import com.knmvstr.evoque.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .ticketId(request.ticketId())
                .build();
    }
}
