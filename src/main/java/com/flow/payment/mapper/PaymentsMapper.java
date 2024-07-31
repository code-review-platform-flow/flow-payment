package com.flow.payment.mapper;

import org.mapstruct.Mapper;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.payment.PaymentsDto;
import com.flow.payment.entity.PaymentsEntity;

@Mapper(componentModel = "spring")
public interface PaymentsMapper extends GenericMapper<PaymentsDto, PaymentsEntity> {
}
