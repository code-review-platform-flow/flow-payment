package com.flow.payment.dto.payment.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class TossPaymentsResponseDto {
	@JsonProperty("mid")
	private String mId;
	@JsonProperty("version")
	private String version;
	@JsonProperty("paymentKey")
	private String paymentKey;
	@JsonProperty("status")
	private String status;
	@JsonProperty("lastTransactionKey")
	private String lastTransactionKey;
	@JsonProperty("method")
	private String method;
	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("orderName")
	private String orderName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Seoul")
	private LocalDateTime requestedAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Seoul")
	private LocalDateTime approvedAt;
	private boolean useEscrow;
	private boolean cultureExpense;
	private int totalAmount;
	private int balanceAmount;
	private int suppliedAmount;
	private int vat;
	private int taxFreeAmount;
}
