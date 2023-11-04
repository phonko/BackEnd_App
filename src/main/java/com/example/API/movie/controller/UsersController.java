package com.example.API.movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.movie.json.UsersListJson;
import com.example.API.movie.model.Users;
import com.example.API.movie.payload.UsersPayload;
import com.example.API.movie.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	UsersService usersservice;
	
	public UsersController(UsersService usersservice) {
		// TODO Auto-generated constructor stub
		this.usersservice = usersservice;
	}
	@GetMapping("/users")
	public List<UsersListJson> getAllUsers(){
		return UsersListJson.packJsons(usersservice.getAllUsers());
	}
	@GetMapping("/users/{id}")
	public UsersListJson getUsersById(@PathVariable long id) {
		return UsersListJson.packJson(usersservice.findById(id));
	}
	@GetMapping("/users/name/{name}")
	public UsersListJson getUsersByNameContaining(@PathVariable String name) {
		return UsersListJson.packJson(usersservice.findByNameContaining(name));
	}
	@GetMapping("/users/email/{email}")
	public UsersListJson getUsersByEmailContaining(@PathVariable String email) {
		return UsersListJson.packJson(usersservice.findByEmailContaining(email));
	}
	@PostMapping("/users")
	public UsersListJson saveUsers(@RequestBody UsersPayload up) {
		Users users = new Users(
				up.getName(),
				up.getAge(),
				up.getAddress(),
				up.getEmail(),
				up.getPassword());
		usersservice.save(users);
		return UsersListJson.packJson(users);
	}
	@PutMapping("/users/{id}")
	public UsersListJson updateUsers(@PathVariable long id, @RequestBody UsersPayload up) {
		Users users = usersservice.findById(id);
		users.setName(up.getName());
		users.setAge(up.getAge());
		users.setAddress(up.getAddress());
		users.setEmail(up.getEmail());
		users.setPassword(up.getPassword());
		usersservice.save(users);
		return UsersListJson.packJson(users);
	}
	@DeleteMapping("/users/{id}")
	public void deleteMovieById(@PathVariable long id) {
		usersservice.deleteById(id);
	}
	@PostMapping("/userss")
	public ResponseEntity<Users> login(@RequestBody Users user) {
	    if (user.getEmail() == null || user.getPassword() == null) {
	        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(null);
	    }

	    Users foundUser = usersservice.findByEmailAndPassword(user.getEmail(), user.getPassword());
	    
	    if (foundUser != null) {
	        return ResponseEntity.ok(foundUser);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}
//	@PostMapping("/userss")
//	public ResponseEntity<?> login(@RequestBody Users user) {
//	    if (user.getEmail() == null || user.getPassword() == null) {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email and password are required");
//	    }
//
//	    Users foundUser = usersservice.findByEmailAndPassword(user.getEmail(), user.getPassword());
//	    
//	    if (foundUser != null) {
//	        return ResponseEntity.ok("User registered Successfully");
//	    } else {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
//	    }
//	}
}

