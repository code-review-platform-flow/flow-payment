package com.flow.payment.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;
import com.flow.payment.dto.users.UsersDto;
import com.flow.payment.entity.OrdersEntity;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, UUID.class})
public interface OrdersMapper extends GenericMapper<OrdersDto, OrdersEntity> {

	@Mapping(target = "userId", source = "user.userId")
	@Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
	@Mapping(target = "customerKey", expression = "java(UUID.randomUUID())")
	@Mapping(target = "status", constant = "주문서 생성")
	OrdersDto toOrdersDto(OrdersRequestDto ordersRequestDto, UsersDto user);

	OrdersResponseDto toOrdersResponseDto(OrdersDto savedOrder);


}
