package com.flow.payment.order;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.*;
import static com.epages.restdocs.apispec.ResourceDocumentation.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.payment.common.exception.CustomNotFoundException;
import com.flow.payment.config.ResourceSnippetIntegrationTest;
import com.flow.payment.dto.payment.request.PaymentsConfirmRequestDto;
import com.flow.payment.dto.payment.request.TossPaymentsRequestDto;
import com.flow.payment.dto.payment.response.PaymentsConfirmResponseDto;
import com.flow.payment.dto.payment.response.TossPaymentsResponseDto;

public class PaymentControllerTest extends ResourceSnippetIntegrationTest {

	@Test
	@DisplayName("결제 성공")
	void paymentSuccess() throws Exception {
		PaymentsConfirmRequestDto request = PaymentsConfirmRequestDto.builder()
			.paymentKey(UUID.randomUUID().toString())
			.amount(BigDecimal.valueOf(1000))
			.tossOrderId(UUID.randomUUID().toString())
			.build();

		PaymentsConfirmResponseDto response = PaymentsConfirmResponseDto.builder().build();

		TossPaymentsResponseDto tossResponse = TossPaymentsResponseDto.builder().build();

		willReturn(tossResponse).given(tossPaymentsService).postConfirm(any(TossPaymentsRequestDto.class));

		given(paymentsConfirmService.confirm(request)).willReturn(response);

		// when
		ResultActions resultActions = mockMvc.perform(
			RestDocumentationRequestBuilders.post("/payment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)));

		resultActions
			.andExpect(status().isOk())
			.andExpect(content().json(new ObjectMapper().writeValueAsString(response)))
			.andDo(document(DEFAULT_RESTDOC_PATH,
				resource(ResourceSnippetParameters.builder()
					.tag("결제")
					.summary("결제")
					.description("결제 요청 API")
					.requestSchema(Schema.schema("결제 요청"))
					.responseSchema(Schema.schema("결제 응답"))
					.requestFields(
						fieldWithPath("paymentKey").description("paymentKey"),
						fieldWithPath("amount").description("총 금액"),
						fieldWithPath("orderId").description("토스 주문 번호 (UUID)")
					)
					.responseFields()
					.build()
				)));
	}

	@Test
	@DisplayName("결제 실패")
	void paymentFail() throws Exception {
		PaymentsConfirmRequestDto request = PaymentsConfirmRequestDto.builder()
			.paymentKey(UUID.randomUUID().toString())
			.amount(BigDecimal.valueOf(1000))
			.tossOrderId(UUID.randomUUID().toString())
			.build();

		willThrow(new CustomNotFoundException())
			.given(tossPaymentsService)
			.postConfirm(any(TossPaymentsRequestDto.class));

		given(paymentsConfirmService.confirm(request)).willThrow(new CustomNotFoundException());

		// when
		ResultActions resultActions = mockMvc.perform(
			RestDocumentationRequestBuilders.post("/payment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)));

		resultActions
			.andExpect(status().isNotFound())
			.andDo(document(DEFAULT_RESTDOC_PATH,
				resource(ResourceSnippetParameters.builder()
					.tag("결제")
					.summary("결제")
					.description("결제 요청 API")
					.requestSchema(Schema.schema("결제 요청"))
					.responseSchema(Schema.schema("결제 응답"))
					.requestFields(
						fieldWithPath("paymentKey").description("paymentKey"),
						fieldWithPath("amount").description("총 금액"),
						fieldWithPath("orderId").description("토스 주문 번호 (UUID)")
					)
					.responseFields()
					.build()
				)));
	}

}
