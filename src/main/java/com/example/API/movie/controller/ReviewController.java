package com.example.API.movie.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.movie.json.ReviewListJson;
import com.example.API.movie.model.Review;
import com.example.API.movie.payload.ReviewsPayload;
import com.example.API.movie.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {
	
	ReviewService reviewservice;
	
	public ReviewController(ReviewService reviewservice) {
		// TODO Auto-generated constructor stub
		this.reviewservice = reviewservice;
	}
	@GetMapping("/review")
	public List<ReviewListJson> getAllMovie(){
		return ReviewListJson.packJsons(reviewservice.findAllReview());
	}
	@GetMapping("/review/{id}")
	public ReviewListJson getReviewById(@PathVariable long id) {
		return ReviewListJson.packJson(reviewservice.findById(id));
	}
	@GetMapping("/review/users/{studentId}")
    public List<ReviewListJson> getBooksByStudentId(@PathVariable long studentId) {
        List<Review> Reviews = reviewservice.findByUsersId(studentId);
        return ReviewListJson.packJsons(Reviews);
    }
	@GetMapping("/review/movie/{video_id}")
    public List<ReviewListJson> getMovieId(@PathVariable long video_id) {
        List<Review> Reviews = reviewservice.findByVideoId(video_id);
        return ReviewListJson.packJsons(Reviews);
    }
	@PostMapping("/review")
	public ReviewListJson saveMovie(@RequestBody ReviewsPayload rv) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		Review review = new Review(
				rv.getUsers(),
				rv.getVideo(),
				rv.getComment(),
				currentDateTime);
		reviewservice.save(review);
		return ReviewListJson.packJson(review);
	}
	@PutMapping("/review/{id}")
	public ReviewListJson updateReview(@PathVariable long id, @RequestBody ReviewsPayload mv) {
		Review movie = reviewservice.findById(id);
		movie.setUsers(mv.getUsers());
		movie.setVideo(mv.getVideo());
//		movie.setScore(mv.getScore());
		movie.setComment(mv.getComment());
		movie.setDates(LocalDateTime.now());
		reviewservice.save(movie);
		return ReviewListJson.packJson(movie);
	}
	@DeleteMapping("/review/{id}")
	public void deleteReviewById(@PathVariable long id) {
		reviewservice.deleteById(id);
	}
}
