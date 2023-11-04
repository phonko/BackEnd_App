package com.example.API.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.movie.service.iml.*;
import com.example.API.movie.model.Status;
import com.example.API.movie.repository.StatusRepository;

@Service
public class StatusService implements IStatus{
	@Autowired
	StatusRepository statusRepository;
	
	public List<Status> findAllStatus(){
		return statusRepository.findAll();
	}
	public Status findById(long id) {
		return statusRepository.findById(id);
	}
	public Status findByNameContaining(String name) {
		return statusRepository.findByNameContaining(name);
	}
	public Status save(Status status) {
		return statusRepository.save(status);
	}
	public void deleteById(long id) {
		statusRepository.deleteById(id);
	}
}
