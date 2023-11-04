package com.example.API.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.movie.model.Status;

public interface StatusRepository extends JpaRepository<Status,Long>{
	Status findById(long id);
	Status findByNameContaining(String name);
}

