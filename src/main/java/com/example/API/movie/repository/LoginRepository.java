package com.example.API.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.movie.model.Login;

public interface LoginRepository extends JpaRepository<Login,Long>{
	Login findById(long id);
//	Login findByUsers(Users users);
}
