package com.flow.payment.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.payment.entity.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
	@Query("SELECT o FROM OrdersEntity o WHERE o.tossOrderId = :tossOrderId")
	Optional<OrdersEntity> findOrdersByTossOrderId(@Param("tossOrderId") UUID tossOrderId);

}
