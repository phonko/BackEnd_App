package com.example.API.movie.payload;

import com.example.API.movie.model.Status;
import com.example.API.movie.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginPayload {
	private Users users;
	private  Status status;
}
