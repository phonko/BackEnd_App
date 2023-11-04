package com.example.API.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.movie.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{
	
	Users findById(long id);
	Users findByNameContaining(String name);
	Users findByEmailContaining(String email);
	Users findByEmailAndPassword(String email, String password);
}