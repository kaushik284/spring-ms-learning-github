package com.learning.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.registration.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
