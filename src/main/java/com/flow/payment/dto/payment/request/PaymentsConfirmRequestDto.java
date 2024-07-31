package com.flow.payment.dto.payment.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsConfirmRequestDto {

	private BigDecimal amount;

	private String paymentKey;

	@JsonProperty("orderId")
	private String tossOrderId;
}
