package com.flow.payment.dto.payment.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentsConfirmResponseDto {
}
