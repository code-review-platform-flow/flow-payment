package com.flow.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.service.orders.OrdersCreateService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrdersCreateService ordersCreateService;

	@PostMapping
	public ResponseEntity<OrdersResponseDto> create(@RequestBody final OrdersRequestDto ordersRequestDto) {
		return ResponseEntity.ok().body(ordersCreateService.create(ordersRequestDto));
	}

}
