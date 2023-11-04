package com.example.API.movie.service.iml;

import java.util.List;

import com.example.API.movie.model.Movie;

public interface IMovie {
	List<Movie> findAllMovie();
	Movie findById(long id);
	Movie findByNameContaining(String name);
	Movie findByTypeContaining(String type);
	Movie save(Movie movie);
	void deleteById(long id);
}
