package com.example.API.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.API.movie.model.Movie;
import com.example.API.movie.repository.MovieRepository;
import com.example.API.movie.service.iml.IMovie;

@Service
public class MovieService implements IMovie{

	MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
	
	public List<Movie> findAllMovie(){
		return movieRepository.findAll();
	}
	public Movie findById(long id) {
		return movieRepository.findById(id);
	}
	public Movie findByNameContaining(String name) {
		return movieRepository.findByNameContaining(name);
	}
	public Movie findByTypeContaining(String type) {
		return movieRepository.findByTypeContaining(type);
	}
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	public void deleteById(long id) {
		movieRepository.deleteById(id);
	}
}
