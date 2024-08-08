package com.flow.payment.entity;

import org.hibernate.annotations.Where;

import com.flow.payment.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "coffee_chats")
@Where(clause = "use_yn = true")
public class CoffeeChatsEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coffee_id")
	private Long coffeeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "initiator_user_id", nullable = false)
	private UsersEntity initiatorUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_user_id", nullable = false)
	private UsersEntity recipientUser;

}
