package com.example.API.movie.service.iml;

import java.util.List;

import com.example.API.movie.model.Users;

public interface IUsers {
	List<Users> getAllUsers();
	Users findById(long id);
	Users findByNameContaining(String name);
	Users findByEmailContaining(String email);
	Users findByEmailAndPassword(String email, String password);
	Users save(Users users);
	void deleteById(long id);
}