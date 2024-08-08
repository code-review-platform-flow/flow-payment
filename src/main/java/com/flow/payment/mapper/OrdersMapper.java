package com.flow.payment.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.entity.OrdersEntity;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, UUID.class}, uses = {CoffeeChatsMapper.class})
public interface OrdersMapper extends GenericMapper<OrdersDto, OrdersEntity> {

	@Mapping(target = "coffeeId", source = "coffee.coffeeId")
	OrdersDto toDto(OrdersEntity entity);

	@Mapping(target = "coffee.coffeeId", source = "coffeeId")
	OrdersEntity toEntity(OrdersDto ordersDto);

	@Mapping(target = "coffeeId", source = "coffeeId")
	@Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
	@Mapping(target = "tossOrderId", expression = "java(UUID.randomUUID())")
	@Mapping(target = "customerKey", expression = "java(UUID.randomUUID())")
	@Mapping(target = "status", constant = "주문서 생성")
	OrdersDto toOrdersDto(OrdersRequestDto ordersRequestDto);

	@Mapping(target = "orderId", source = "orderId")
	OrdersResponseDto toOrdersResponseDto(OrdersDto savedOrder);

}
