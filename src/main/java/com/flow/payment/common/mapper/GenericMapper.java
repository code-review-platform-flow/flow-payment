package com.flow.payment.common.mapper;

import java.util.List;

public interface GenericMapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

}
