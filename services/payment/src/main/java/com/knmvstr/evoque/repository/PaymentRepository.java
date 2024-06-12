package com.knmvstr.evoque.repository;

import com.knmvstr.evoque.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
