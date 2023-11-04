package com.example.API.movie.service.iml;

import java.util.List;

import com.example.API.movie.model.Login;

public interface ILogin {
	List<Login> findAllLogin();
	Login findById(long id);
//	Login findByUsers(Users users);
	Login save(Login login);
	void deleteById(long id);
}
