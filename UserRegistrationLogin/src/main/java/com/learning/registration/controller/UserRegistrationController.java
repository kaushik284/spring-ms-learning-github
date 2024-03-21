package com.learning.registration.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.registration.dto.UserDto;
import com.learning.registration.exceptions.UserAlreadyExistsException;
import com.learning.registration.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class UserRegistrationController {

	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> create(@RequestBody UserDto user) {
		UserDto createdUser = null; 
		try {
			createdUser = userService.saveUser(user);
			return ResponseEntity.ok(createdUser);
		} catch (UserAlreadyExistsException e) {
			log.error("Exception: "+ e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/users")
	public List<UserDto> getAll(){
		return userService.findAllUsers();
	}
}
