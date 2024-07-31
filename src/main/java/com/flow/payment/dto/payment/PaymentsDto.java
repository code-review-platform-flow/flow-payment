package com.flow.payment.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsDto {

	private Long paymentId;
	private Long userId;
	private String paymentKey;
	private String status;

}
