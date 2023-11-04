package com.example.API.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
	Movie findById(long id);
	Movie findByNameContaining(String name);
	Movie findByTypeContaining(String type);
}
