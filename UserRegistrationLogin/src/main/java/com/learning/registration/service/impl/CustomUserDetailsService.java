package com.learning.registration.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.registration.entity.User;
import com.learning.registration.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// load the user from db
		User user = userRepository.findByEmail(email);
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(),
					user.getPassword(),
					user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
					.toList());
					
		}
		else {
			throw new UsernameNotFoundException("Invalid username or password");
		}
	}

}
