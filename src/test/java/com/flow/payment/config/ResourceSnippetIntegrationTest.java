package com.flow.payment.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.flow.payment.common.client.TossPaymentsApiAdapter;
import com.flow.payment.controller.OrderController;
import com.flow.payment.controller.PaymentsController;
import com.flow.payment.service.orders.OrdersCreateService;
import com.flow.payment.service.payment.PaymentsConfirmService;
import com.flow.payment.service.payment.TossPaymentsService;

@ExtendWith({RestDocumentationExtension.class})
@WebMvcTest(
	controllers = {
		PaymentsController.class,
		OrderController.class
	}
)
@AutoConfigureRestDocs
public abstract class ResourceSnippetIntegrationTest {

	protected static final String DEFAULT_RESTDOC_PATH = "{class_name}/{method_name}";

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	protected OrdersCreateService ordersCreateService;

	@MockBean
	protected PaymentsConfirmService paymentsConfirmService;

	@MockBean
	protected TossPaymentsService tossPaymentsService;

	@BeforeEach
	void setUp(final WebApplicationContext context, final RestDocumentationContextProvider provider) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
			.apply(MockMvcRestDocumentation.documentationConfiguration(provider)
				//요청 body 의 payload 를 보기 좋게 출력
				.operationPreprocessors().withRequestDefaults(Preprocessors.prettyPrint())
				.and()
				//응답 body 의 payload 를 보기 좋게 출력
				.operationPreprocessors().withResponseDefaults(Preprocessors.prettyPrint()))
			//테스트 결과를 항상 print
			.alwaysDo(MockMvcResultHandlers.print())
			//한글 깨짐 방지
			.addFilter(new CharacterEncodingFilter("UTF-8", true))
			.build();
	}

}