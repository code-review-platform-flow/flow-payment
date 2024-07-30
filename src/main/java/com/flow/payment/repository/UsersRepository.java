package com.flow.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.payment.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	@Query("SELECT u FROM UsersEntity u WHERE u.email = :email")
	Optional<UsersEntity> findUsersByEmail(@Param("email") String email);

}
