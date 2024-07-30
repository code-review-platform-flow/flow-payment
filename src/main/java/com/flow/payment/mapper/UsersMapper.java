package com.flow.payment.mapper;

import org.mapstruct.Mapper;

import com.flow.payment.common.mapper.GenericMapper;
import com.flow.payment.dto.users.UsersDto;
import com.flow.payment.entity.UsersEntity;

@Mapper(componentModel = "spring")
public interface UsersMapper extends GenericMapper<UsersDto, UsersEntity> {
}
