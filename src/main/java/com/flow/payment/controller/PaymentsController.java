package com.flow.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.dto.payment.request.PaymentsConfirmRequestDto;
import com.flow.payment.dto.payment.response.PaymentsConfirmResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentsController {

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody final PaymentsConfirmRequestDto paymentsConfirmRequestDto) {
		return null;
	}

}
