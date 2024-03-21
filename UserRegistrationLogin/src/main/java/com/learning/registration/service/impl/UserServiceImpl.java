package com.learning.registration.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.registration.constants.UserRegistrationConstants;
import com.learning.registration.dto.UserDto;
import com.learning.registration.entity.Role;
import com.learning.registration.entity.User;
import com.learning.registration.exceptions.UserAlreadyExistsException;
import com.learning.registration.repo.RoleRepository;
import com.learning.registration.repo.UserRepository;
import com.learning.registration.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto saveUser(UserDto userDto) throws UserAlreadyExistsException {
		boolean userRegistered = isUserRegistered(userDto);
		if(userRegistered) {
			throw new UserAlreadyExistsException("The user already exists");
		}
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		Role role = roleRepository.findByName(UserRegistrationConstants.ROLE_ADMIN);
		if(role == null) {
			role = saveRole(UserRegistrationConstants.ROLE_ADMIN);
		}
		
		user.setRoles(Arrays.asList(role));
		User savedUser = userRepository.save(user);
		
		return mapUserToUserDto(savedUser);
	}

	private boolean isUserRegistered(UserDto userDto) {
		if(userRepository.findByEmail(userDto.getEmail())!=null)
			return true;
		return false;
		
	}

	private UserDto mapUserToUserDto(User user) {
		UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(), null);
		return userDto;
	}

	private Role saveRole(String roleName) {
		Role role = new Role();
		role.setName(roleName);
		
		return roleRepository.save(role);
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map(this::mapUserToUserDto)
		.toList();
	}

}
