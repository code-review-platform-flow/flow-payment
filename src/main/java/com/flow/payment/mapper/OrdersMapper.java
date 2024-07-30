package com.flow.payment.mapper;

import org.mapstruct.Mapper;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.order.OrdersDto;
import com.flow.payment.entity.OrdersEntity;

@Mapper(componentModel = "spring")
public interface OrdersMapper extends GenericMapper<OrdersDto, OrdersEntity> {

}
