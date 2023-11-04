package com.example.API.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.movie.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{
	Review findById(long id);
	List<Review> findByUsersId(long id);
	List<Review> findByVideoId(long id);
}
