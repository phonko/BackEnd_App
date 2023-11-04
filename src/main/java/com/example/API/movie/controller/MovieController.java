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

import com.example.API.movie.json.MovieListJson;
import com.example.API.movie.model.Movie;
import com.example.API.movie.payload.MoviePayload;
import com.example.API.movie.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	MovieService movieservice;
	
	public MovieController(MovieService movieservice) {
		// TODO Auto-generated constructor stub
		this.movieservice = movieservice;
	}
	@GetMapping("/movie")
	public List<MovieListJson> getAllMovie(){
		return MovieListJson.packJsons(movieservice.findAllMovie());
	}
	@GetMapping("/movie/{id}")
	public MovieListJson getMovieById(@PathVariable long id) {
		return MovieListJson.packJson(movieservice.findById(id));
	}
	@GetMapping("/movie/name/{name}")
	public MovieListJson getMovieByNameContaining(@PathVariable String name) {
		return MovieListJson.packJson(movieservice.findByNameContaining(name));
	}
	@GetMapping("/movie/type/{type}")
	public MovieListJson getMovieByTypeContaining(@PathVariable String type) {
		return MovieListJson.packJson(movieservice.findByTypeContaining(type));
	}
	@PostMapping("/movie")
	public MovieListJson saveMovie(@RequestBody MoviePayload mv) {
		Movie movie = new Movie(
				mv.getName(),
				mv.getImgage(),
				mv.getVideo(),
				mv.getType(),
				mv.getDescription());
		movieservice.save(movie);
		return MovieListJson.packJson(movie);
	}
	@PutMapping("/movie/{id}")
	public MovieListJson updateMovie(@PathVariable long id, @RequestBody MoviePayload mv) {
		Movie movie = movieservice.findById(id);
		movie.setName(mv.getName());
		movie.setImgage(mv.getImgage());
		movie.setVideo(mv.getVideo());
		movie.setType(mv.getType());
		movie.setDescription(mv.getDescription());
		movieservice.save(movie);
		return MovieListJson.packJson(movie);
	}
	@DeleteMapping("/movie/{id}")
	public void deleteMovieById(@PathVariable long id) {
		movieservice.deleteById(id);
	}
}
