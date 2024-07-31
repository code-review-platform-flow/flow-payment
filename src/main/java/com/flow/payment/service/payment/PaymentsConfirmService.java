package com.flow.payment.service.payment;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.dto.payment.PaymentsDto;
import com.flow.payment.dto.payment.request.PaymentsConfirmRequestDto;
import com.flow.payment.dto.payment.request.TossPaymentsRequestDto;
import com.flow.payment.dto.payment.response.PaymentsConfirmResponseDto;
import com.flow.payment.dto.payment.response.TossPaymentsResponseDto;
import com.flow.payment.service.orders.persistence.OrdersService;
import com.flow.payment.service.payment.persistence.PaymentsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentsConfirmService {

	private final OrdersService ordersService;
	private final PaymentsService paymentsService;
	private final TossPaymentsService tossPaymentsService;

	public PaymentsConfirmResponseDto confirm (PaymentsConfirmRequestDto paymentsConfirmRequestDto) {
		TossPaymentsRequestDto tossPaymentsRequest = TossPaymentsRequestDto.builder()
			.paymentKey(paymentsConfirmRequestDto.getPaymentKey())
			.orderId(paymentsConfirmRequestDto.getTossOrderId())
			.amount(paymentsConfirmRequestDto.getAmount())
			.build();

		OrdersDto ordersDto = ordersService.findOrdersByTossOrderId(UUID.fromString(paymentsConfirmRequestDto.getTossOrderId()));

		PaymentsDto payments = PaymentsDto.builder()
			.orderId(ordersDto.getOrderId())
			.paymentKey(paymentsConfirmRequestDto.getPaymentKey())
			.amount(paymentsConfirmRequestDto.getAmount())
			.status("결제 성공")
			.build();

		TossPaymentsResponseDto tossPaymentsResponseDto = tossPaymentsService.postConfirm(tossPaymentsRequest);

		paymentsService.save(payments);

		return PaymentsConfirmResponseDto.builder().mId(tossPaymentsResponseDto.getMId()).build();
	}

}
