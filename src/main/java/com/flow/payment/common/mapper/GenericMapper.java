package com.flow.payment.common.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface GenericMapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

}
