package com.flow.payment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.payment.PaymentsDto;
import com.flow.payment.entity.PaymentsEntity;

@Mapper(componentModel = "spring", uses = {OrdersMapper.class, CoffeeChatsMapper.class})
public interface PaymentsMapper extends GenericMapper<PaymentsDto, PaymentsEntity> {

	@Mapping(target = "orderId", source = "order.orderId")
	PaymentsDto toDto(PaymentsEntity paymentsEntity);

	@Mapping(target = "order.orderId", source = "orderId")
	PaymentsEntity toEntity(PaymentsDto paymentsDto);

}
