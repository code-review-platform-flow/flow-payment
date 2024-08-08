package com.flow.payment.mapper;

import org.mapstruct.Mapper;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.coffee.CoffeeChatsDto;
import com.flow.payment.entity.CoffeeChatsEntity;

@Mapper(componentModel = "spring")
public interface CoffeeChatsMapper extends GenericMapper<CoffeeChatsDto, CoffeeChatsEntity> {
}
