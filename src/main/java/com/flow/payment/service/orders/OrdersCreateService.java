package com.flow.payment.service.orders;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.dto.users.UsersDto;
import com.flow.payment.mapper.OrdersMapper;
import com.flow.payment.service.orders.persistence.OrdersService;
import com.flow.payment.service.users.persistence.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersCreateService {

	private final UsersService usersService;
	private final OrdersService ordersService;
	private final OrdersMapper ordersMapper;


	public OrdersResponseDto create(OrdersRequestDto ordersRequestDto) {
		// 사용자 정보를 이메일로 찾기
		UsersDto user = usersService.findUsersByEmail(ordersRequestDto.getEmail());

		// 주문 정보를 생성 및 저장
		OrdersDto newOrder = ordersMapper.toOrdersDto(ordersRequestDto, user);
		OrdersDto savedOrder = ordersService.save(newOrder);

		// 응답 DTO 생성 및 반환
		return ordersMapper.toOrdersResponseDto(savedOrder);
	}

}
