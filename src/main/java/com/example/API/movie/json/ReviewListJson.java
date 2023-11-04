package com.example.API.movie.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.API.movie.model.Movie;
import com.example.API.movie.model.Review;
import com.example.API.movie.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewListJson {
	private long id;
	private Users users;
	private Movie video;
//	private Integer score;
	private String comment;
	private LocalDateTime dates;
	
	public static ReviewListJson packJson(Review review) {
		ReviewListJson rlj = new ReviewListJson();
		rlj.setId(review.getId());
		rlj.setUsers(review.getUsers());
		rlj.setVideo(review.getVideo());
//		rlj.setScore(review.getScore());
		rlj.setComment(review.getComment());
		rlj.setDates(review.getDates());
		return rlj;
	}
	public static List<ReviewListJson> packJsons(List<Review>rv){
		List<ReviewListJson> rlj = new ArrayList<ReviewListJson>();
		for(Review review : rv) {
			rlj.add(packJson(review));
		}
		return rlj;
	}
}
