package com.example.API.movie.payload;

import java.time.LocalDateTime;

import com.example.API.movie.model.Movie;
import com.example.API.movie.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewsPayload {
	private Users users;
	private Movie video;
//	private Integer score;
	private String comment;
	private LocalDateTime dates;
}
