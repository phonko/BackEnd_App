package com.example.API.movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.movie.json.LoginListJson;
import com.example.API.movie.model.Login;
import com.example.API.movie.payload.LoginPayload;
import com.example.API.movie.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	LoginService loginservice;
	
	public LoginController(LoginService loginservice) {
		// TODO Auto-generated constructor stub
		this.loginservice = loginservice;
	}
	
	@GetMapping("/login")
	public List<LoginListJson> getAllMovie(){
		return LoginListJson.packJsons(loginservice.findAllLogin());
	}
	@GetMapping("/login/{id}")
	public LoginListJson getMovieById(@PathVariable long id) {
		return LoginListJson.packJson(loginservice.findById(id));
	}
	@PostMapping("/login")
	public LoginListJson saveLogin(@RequestBody LoginPayload lg) {
		Login login = new Login(
				lg.getUsers(),
				lg.getStatus());
		loginservice.save(login);
		return LoginListJson.packJson(login);
	}
	@PutMapping("/login/{id}")
	public LoginListJson updateLogin(@PathVariable long id, @RequestBody LoginPayload lg) {
		Login movie = loginservice.findById(id);
		movie.setStatus(lg.getStatus());
		loginservice.save(movie);
		return LoginListJson.packJson(movie);
	}
	@DeleteMapping("/login/{id}")
	public void deleteLoginById(@PathVariable long id) {
		loginservice.deleteById(id);
	}
}
