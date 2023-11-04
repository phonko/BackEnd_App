package com.example.API.movie.json;

import java.util.ArrayList;
import java.util.List;

import com.example.API.movie.json.MovieListJson;
import com.example.API.movie.model.Movie;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieListJson {
	private long id;
	private String name;
	private String imgage;
	private String video;
	private String type;
	private String description;
	
	public static MovieListJson packJson(Movie movie) {
		MovieListJson mlj = new MovieListJson();
		mlj.setId(movie.getId());
		mlj.setName(movie.getName());
		mlj.setImgage(movie.getImgage());
		mlj.setVideo(movie.getVideo());
		mlj.setType(movie.getType());
		mlj.setDescription(movie.getDescription());
		return mlj;
	}
	public static List<MovieListJson> packJsons(List<Movie>mv){
		List<MovieListJson> mlj = new ArrayList<MovieListJson>();
		for(Movie movie : mv) {
			mlj.add(packJson(movie));
		}
		return mlj;
	}
}
