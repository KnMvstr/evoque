package com.knmvstr.evoque.controller;

import com.knmvstr.evoque.controller.record.PaymentRequest;
import com.knmvstr.evoque.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> createPayment(@RequestBody @Valid PaymentRequest request) {
        return ResponseEntity.ok(paymentService.createPayment(request));
    }
}
