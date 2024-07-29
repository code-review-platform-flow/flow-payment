package com.flow.payment.entity;

import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
@Table(name = "payment_logs")
public class PaymentLogsEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private Long logId;

	@Column(name = "order_id", nullable = false)
	private Integer orderId;

	@Column(name = "event_type", nullable = false, length = 50)
	private String eventType;

	@Column(name = "request")
	@JdbcTypeCode(SqlTypes.JSON)
	private Map<String, Object> request;

	@Column(name = "response")
	@JdbcTypeCode(SqlTypes.JSON)
	private Map<String, Object> response;

}
