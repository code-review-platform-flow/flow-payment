package com.flow.payment.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration

public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
			.codecs(configurer -> {
				configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(mapper));
				configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper));
			})
			.build();

		exchangeStrategies
			.messageWriters().stream()
			.filter(LoggingCodecSupport.class::isInstance)
			.forEach(writer -> ((LoggingCodecSupport) writer).setEnableLoggingRequestDetails(true));

		return WebClient.builder()
			.exchangeStrategies(exchangeStrategies)
			.build();
	}

}
