package com.flow.payment.service.orders;

import org.springframework.stereotype.Service;

import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.service.orders.persistence.OrdersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersCreateService {

	private final OrdersService ordersService;

	public Void create(OrdersRequestDto ordersRequestDto) {
		// return OrdersResponseDto.builder().build();
		return null;
	}

}
