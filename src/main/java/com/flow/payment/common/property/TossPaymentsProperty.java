package com.flow.payment.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "toss.payments")
public class TossPaymentsProperty {
	private String widgetSecretKey;
}
