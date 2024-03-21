package com.learning.registration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.registration.dto.UserDto;
import com.learning.registration.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class UserRegistrationController {

	private final UserService userService;
	
	@PostMapping("/create")
	public UserDto create(@RequestBody UserDto user) {
		return userService.saveUser(user);
	}
}
