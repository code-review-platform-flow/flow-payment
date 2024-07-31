package com.flow.payment.service.payment.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.payment.dto.payment.PaymentsDto;
import com.flow.payment.entity.PaymentsEntity;
import com.flow.payment.mapper.PaymentsMapper;
import com.flow.payment.repository.PaymentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentsService {

	private final PaymentsRepository paymentsRepository;
	private final PaymentsMapper paymentsMapper;

	@Transactional
	public PaymentsDto save(PaymentsDto paymentsDto) {
		PaymentsEntity payments = paymentsMapper.toEntity(paymentsDto);
		paymentsRepository.save(payments);
		return paymentsMapper.toDto(payments);
	}

}
