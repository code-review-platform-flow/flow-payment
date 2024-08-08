package com.flow.payment.dto.coffee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeChatsDto {
	private Long coffeeId;
	private Long initiatorUserId;
	private Long recipientUserId;
}
