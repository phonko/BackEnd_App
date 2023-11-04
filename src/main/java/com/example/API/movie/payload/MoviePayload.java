package com.example.API.movie.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MoviePayload {
	private String name;
	private String imgage;
	private String video;
	private String type;
	private String description;
}
