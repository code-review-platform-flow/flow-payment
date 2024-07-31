package com.flow.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flow.payment.entity.PaymentsEntity;

public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Long> {
}
