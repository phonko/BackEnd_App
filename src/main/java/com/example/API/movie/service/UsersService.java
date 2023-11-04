package com.example.API.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.API.movie.model.Users;
import com.example.API.movie.repository.UsersRepository;
import com.example.API.movie.service.iml.IUsers;

@Service
public class UsersService implements IUsers{
	
	UsersRepository usersRepository;
	
	public UsersService(UsersRepository usersRepository) {
		// TODO Auto-generated constructor stub
		this.usersRepository = usersRepository;
	}
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	public Users findById(long id) {
		return usersRepository.findById(id);
	}
	public Users findByNameContaining(String name) {
		return usersRepository.findByNameContaining(name);
	}
	public Users findByEmailContaining(String email) {
		return usersRepository.findByEmailContaining(email);
	}
	public Users findByEmailAndPassword(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }
	public Users save(Users users) {
		return usersRepository.save(users);
	}
	public void deleteById(long id) {
		usersRepository.deleteById(id);
	}
}
