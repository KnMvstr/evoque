package com.knmvstr.evoque.client.payment_client;

import com.knmvstr.evoque.controller.record.ticket.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        name = "payment-service",
        url ="${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    Long requestTicketPayment(@RequestBody PaymentRequest request);

}
