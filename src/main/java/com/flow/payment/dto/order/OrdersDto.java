package com.flow.payment.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {

	private Long orderId;
	private Integer userId;
	private UUID customerKey;
	private LocalDateTime orderDate;
	private BigDecimal totalAmount;
	private String status;

}

