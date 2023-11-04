package com.example.API.movie.service.iml;

import java.util.List;

import com.example.API.movie.model.Status;

public interface IStatus {
	List<Status> findAllStatus();
	Status findById(long id);
	Status findByNameContaining(String name);
	Status save(Status status);
	void deleteById(long id);
}
