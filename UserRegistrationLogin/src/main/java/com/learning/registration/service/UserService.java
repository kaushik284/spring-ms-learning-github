package com.learning.registration.service;

import java.util.List;

import com.learning.registration.dto.UserDto;
import com.learning.registration.entity.User;

public interface UserService {

	UserDto saveUser(UserDto user);
	
	User findUserByEmail(String email);
	
	List<UserDto> findAllUsers();
}
