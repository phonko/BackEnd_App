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

import com.example.API.movie.json.StatusListJson;
import com.example.API.movie.model.Status;
import com.example.API.movie.payload.StatusPayload;
import com.example.API.movie.service.StatusService;

@RestController
@RequestMapping("/api")
public class StatusController {
StatusService statusservice;
	
	public StatusController(StatusService statusservice) {
		// TODO Auto-generated constructor stub
		this.statusservice = statusservice;
	}
	@GetMapping("/status")
	public List<StatusListJson> getAllStatus() {
	    return StatusListJson.packJsons(statusservice.findAllStatus());
	}
	@GetMapping("/status/{id}")
	public StatusListJson getStatusById(@PathVariable long id) {
		return StatusListJson.packJson(statusservice.findById(id));
	}
	@GetMapping("/status/name/{name}")
	public StatusListJson getStatusByNameContaining(@PathVariable String name) {
		return StatusListJson.packJson(statusservice.findByNameContaining(name));
	}
	@PostMapping("/status")
	public StatusListJson saveStatus(@RequestBody StatusPayload st) {
		Status status = new Status(
				st.getName());
		statusservice.save(status);
		return StatusListJson.packJson(status);
	}
	@PutMapping("/status/{id}")
	public StatusListJson updateStatus(@PathVariable long id, @RequestBody StatusPayload st) {
		Status status = statusservice.findById(id);
		status.setName(st.getName());
		statusservice.save(status);
		return StatusListJson.packJson(status);
	}
	@DeleteMapping("/status/{id}")
	public void deleteStatusById(@PathVariable long id) {
	  statusservice.deleteById(id);
	}
}
