package com.flow.payment.service.users.persistence;

import org.springframework.stereotype.Service;

import com.flow.payment.dto.users.UsersDto;
import com.flow.payment.entity.UsersEntity;
import com.flow.payment.mapper.UsersMapper;
import com.flow.payment.repository.UsersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersMapper;

	public UsersDto findUsersByEmail(String email) {
		return usersMapper.toDto(usersRepository.findUsersByEmail(email)
			.orElseThrow(() -> new RuntimeException("User not found with email: " + email)));
	}

}
