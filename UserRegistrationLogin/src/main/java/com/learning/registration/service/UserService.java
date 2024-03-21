package com.learning.registration.service;

import java.util.List;

import com.learning.registration.dto.UserDto;
import com.learning.registration.entity.User;
import com.learning.registration.exceptions.UserAlreadyExistsException;

public interface UserService {

	UserDto saveUser(UserDto user) throws UserAlreadyExistsException;
	
	User findUserByEmail(String email);
	
	List<UserDto> findAllUsers();
}
