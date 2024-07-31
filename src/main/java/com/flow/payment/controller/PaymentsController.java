package com.flow.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.payment.dto.payment.request.PaymentsConfirmRequestDto;
import com.flow.payment.dto.payment.response.PaymentsConfirmResponseDto;
import com.flow.payment.service.payment.PaymentsConfirmService;
import com.flow.payment.service.payment.persistence.PaymentsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentsController {

	private final PaymentsConfirmService paymentsConfirmService;

	@PostMapping
	public ResponseEntity<PaymentsConfirmResponseDto> create(@RequestBody final PaymentsConfirmRequestDto paymentsConfirmRequestDto) {
		return ResponseEntity.ok().body(paymentsConfirmService.confirm(paymentsConfirmRequestDto));
	}

}