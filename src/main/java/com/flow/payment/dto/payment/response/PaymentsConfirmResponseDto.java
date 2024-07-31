package com.flow.payment.dto.payment.response;

import java.time.LocalDateTime;

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
public class PaymentsConfirmResponseDto {
	private String mId;
	private String version;
	private String paymentKey;
	private String status;
	private String lastTransactionKey;
	private String method;
	private String orderId;
	private String orderName;
	private LocalDateTime requestedAt;
	private LocalDateTime approvedAt;
	private boolean useEscrow;
	private boolean cultureExpense;
	private CardInfo card;
	private int totalAmount;
	private int balanceAmount;
	private int suppliedAmount;
	private int vat;
	private int taxFreeAmount;
}
