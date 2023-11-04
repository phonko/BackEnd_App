package com.example.API.movie.service.iml;

import java.util.List;

import com.example.API.movie.model.Review;

public interface IReview {
	List<Review> findAllReview();
	Review findById(long id);
	List<Review> findByUsersId(long id);
	List<Review> findByVideoId(long id);
	Review save(Review review);
	void deleteById(long id);
}
