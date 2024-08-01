package com.flow.payment.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.payment.common.exception.CustomNotFoundException;
import com.flow.payment.config.ResourceSnippetIntegrationTest;
import com.flow.payment.dto.order.request.OrdersRequestDto;
import com.flow.payment.dto.order.response.OrdersResponseDto;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.*;
import static com.epages.restdocs.apispec.ResourceDocumentation.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderControllerTest extends ResourceSnippetIntegrationTest {

	@Test
	@DisplayName("주문 생성 성공")
	void createOrderSuccess() throws Exception {
		OrdersRequestDto request = OrdersRequestDto.builder().email("a1061602@gachon.ac.kr").totalAmount(
			BigDecimal.valueOf(1000)).build();
		OrdersResponseDto response = OrdersResponseDto.builder()
			.orderId(1L)
			.customerKey(UUID.randomUUID())
			.tossOrderId(UUID.randomUUID().toString())
			.build();

		given(ordersCreateService.create(request)).willReturn(response);

		// when
		ResultActions resultActions = mockMvc.perform(
			RestDocumentationRequestBuilders.post("/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)));

		resultActions
			.andExpect(status().isOk())
			.andExpect(content().json(new ObjectMapper().writeValueAsString(response)))
			.andDo(document(DEFAULT_RESTDOC_PATH,
				resource(ResourceSnippetParameters.builder()
					.tag("주문")
					.summary("주문 생성")
					.description("주문 생성 요청 API")
					.requestSchema(Schema.schema("주문 생성 요청"))
					.responseSchema(Schema.schema("주문 생성 응답"))
					.requestFields(
						fieldWithPath("email").description("이메일"),
						fieldWithPath("totalAmount").description("총 금액")
					)
					.responseFields(
						fieldWithPath("orderId").description("자체 주문 번호"),
						fieldWithPath("customerKey").description("고객 번호 (UUID)"),
						fieldWithPath("tossOrderId").description("토스 주문 번호 (UUID)")
					)
					.build()
				)));
	}

	@Test
	@DisplayName("주문 생성 실패")
	void createOrderFailByEmail() throws Exception {
		OrdersRequestDto request = OrdersRequestDto.builder().email("a1061602@gmail.com").totalAmount(
			BigDecimal.valueOf(1000)).build();

		given(ordersCreateService.create(request)).willThrow(new CustomNotFoundException());

		// when
		ResultActions resultActions = mockMvc.perform(
			RestDocumentationRequestBuilders.post("/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)));

		resultActions
			.andExpect(status().isNotFound())
			.andDo(document(DEFAULT_RESTDOC_PATH,
				resource(ResourceSnippetParameters.builder()
					.tag("주문")
					.summary("주문 생성")
					.description("주문 생성 요청 API")
					.requestSchema(Schema.schema("주문 생성 요청"))
					.responseSchema(Schema.schema("주문 생성 응답"))
					.requestFields(
						fieldWithPath("email").description("이메일"),
						fieldWithPath("totalAmount").description("총 금액")
					)
					.responseFields()
					.build()
				)));
	}
}