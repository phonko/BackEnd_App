package com.example.API.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.API.exception.BaseException;
import com.example.API.movie.exception.MovieException;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class MovieException extends BaseException{ 
	private static final long serialVersionUID = 1L;
	
	public MovieException(String code, HttpStatus status) { 
		super("student." + code, status);
	}
	public static MovieException emptyStudent() {
		return new MovieException("findStudent.notFound", HttpStatus.BAD_REQUEST);
	}
}