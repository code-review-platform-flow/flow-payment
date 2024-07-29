package com.flow.payment.entity;

import com.flow.payment.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "payments")
public class PaymentsEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "payment_key", nullable = false, length = 255)
	private String paymentKey;

	@Column(name = "status", nullable = false, length = 20)
	private String status;

}
