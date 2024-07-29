package com.flow.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flow.payment.entity.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

}
