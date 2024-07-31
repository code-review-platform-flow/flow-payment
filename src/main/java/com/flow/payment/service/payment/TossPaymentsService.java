package com.flow.payment.service.payment;

import org.springframework.stereotype.Service;

import com.flow.payment.common.client.TossPaymentsApiAdapter;
import com.flow.payment.dto.payment.request.TossPaymentsRequestDto;
import com.flow.payment.dto.payment.response.TossPaymentsResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TossPaymentsService {

	private final TossPaymentsApiAdapter tossPaymentsApiAdapter;

	public TossPaymentsResponseDto postConfirm(TossPaymentsRequestDto tossPaymentsRequestDto) {
		return tossPaymentsApiAdapter.confirm(tossPaymentsRequestDto);
	}

}
