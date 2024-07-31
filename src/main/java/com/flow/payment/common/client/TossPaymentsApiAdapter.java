package com.flow.payment.common.client;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.flow.payment.common.property.TossPaymentsProperty;
import com.flow.payment.dto.payment.request.TossPaymentsRequestDto;
import com.flow.payment.dto.payment.response.TossPaymentsResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class TossPaymentsApiAdapter {

	private final WebClient webClient;
	private final TossPaymentsProperty tossPaymentsProperty;

	public TossPaymentsResponseDto confirm(TossPaymentsRequestDto tossPaymentsRequestDto) {

		// Basic Auth 설정
		String authorizations = "Basic " + Base64.getEncoder().encodeToString((tossPaymentsProperty.getWidgetSecretKey() + ":").getBytes(StandardCharsets.UTF_8));

		return webClient.post()
			.uri("https://api.tosspayments.com/v1/payments/confirm")
			.header("Authorization", authorizations)
			.contentType(MediaType.APPLICATION_JSON)
			.bodyValue(tossPaymentsRequestDto)
			.retrieve()
			.onStatus(HttpStatusCode::isError, clientResponse -> handleError(clientResponse))
			.bodyToMono(TossPaymentsResponseDto.class)
			.block();

	}

	private Mono<WebClientResponseException> handleError(ClientResponse clientResponse) {
		return clientResponse.bodyToMono(String.class)
			.flatMap(errorBody -> {
				log.error("Error response from Toss Payments: {}", errorBody);
				return Mono.error(new WebClientResponseException(
					"API request failed",
					clientResponse.statusCode().value(),
					clientResponse.statusCode().toString(),
					clientResponse.headers().asHttpHeaders(),
					errorBody.getBytes(StandardCharsets.UTF_8),
					StandardCharsets.UTF_8));
			});
	}

}
