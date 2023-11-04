package com.example.API.movie.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersPayload {
	
	private String name;
	private Integer age;
	private String address;
	private String email;
	private String password;
}
