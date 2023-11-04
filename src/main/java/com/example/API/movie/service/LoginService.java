package com.example.API.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.API.movie.model.Login;
import com.example.API.movie.repository.LoginRepository;
import com.example.API.movie.service.iml.ILogin;

@Service
public class LoginService implements ILogin{
	
	LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
	public List<Login> findAllLogin(){
		return loginRepository.findAll();
	}
	public Login findById(long id) {
		return loginRepository.findById(id);
	}
//	public Login findByUsers(Users users) {
//		return loginRepository.findByUsers(users);
//	}
	public Login save(Login login) {
		return loginRepository.save(login);
	}
	public void deleteById(long id) {
		loginRepository.deleteById(id);
	}
}
