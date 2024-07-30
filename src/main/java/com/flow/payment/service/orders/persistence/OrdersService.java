package com.flow.payment.service.orders.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.entity.OrdersEntity;
import com.flow.payment.mapper.OrdersMapper;
import com.flow.payment.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersService {

	private final OrdersRepository ordersRepository;
	private final OrdersMapper ordersMapper;

	@Transactional
	public OrdersDto save(OrdersDto ordersDto) {
		OrdersEntity orders = ordersMapper.toEntity(ordersDto);
		ordersRepository.save(orders);
		return ordersMapper.toDto(orders);
	}

}
