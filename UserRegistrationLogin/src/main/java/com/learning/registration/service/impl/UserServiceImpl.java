package com.learning.registration.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.registration.dto.UserDto;
import com.learning.registration.entity.User;
import com.learning.registration.repo.RoleRepository;
import com.learning.registration.repo.UserRepository;
import com.learning.registration.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	
	@Override
	public UserDto saveUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
