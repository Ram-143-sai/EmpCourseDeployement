package com.knf.dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knf.dev.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUsername(String username);

	User findById(long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
