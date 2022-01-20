package com.jopaulo.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.movie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
