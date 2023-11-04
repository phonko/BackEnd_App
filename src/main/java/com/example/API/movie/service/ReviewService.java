package com.example.API.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.API.movie.model.Review;
import com.example.API.movie.repository.ReviewRepository;
import com.example.API.movie.service.iml.IReview;

@Service
public class ReviewService implements IReview{
	
	ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		// TODO Auto-generated constructor stub
		this.reviewRepository = reviewRepository;
	}
	public List<Review> findAllReview(){
		return reviewRepository.findAll();
	}
	public Review findById(long id) {
		return reviewRepository.findById(id);
	}
	public List<Review> findByUsersId(long id) {
		return reviewRepository.findByUsersId(id);
	}
	public List<Review> findByVideoId(long id) {
		return reviewRepository.findByVideoId(id);
	}
	public Review save(Review review) {
		return reviewRepository.save(review);
	}
	public void deleteById(long id) {
		reviewRepository.deleteById(id);
	}
}
