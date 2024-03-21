package com.learning.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.registration.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
