package com.flow.payment.dto.payment.response;

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
public class CardInfo {
	private String issuerCode;
	private String acquirerCode;
	private String number;
	private int installmentPlanMonths;
	private boolean isInterestFree;
	private String interestPayer;
	private String approveNo;
	private boolean useCardPoint;
	private String cardType;
	private String ownerType;
	private String acquireStatus;
	private int amount;
}
