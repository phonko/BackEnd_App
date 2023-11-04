package com.example.API.movie.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//import com.example.API.movie.model.Movie;
//import com.example.API.movie.model.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Reviews")
@Table(
		name = "Reviews"
)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private Users users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "video_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private Movie video;
	
//	@Column(name = "score", nullable = false)
//	private Integer score;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@CreationTimestamp
	@Column(name = "dates", nullable = false, 
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dates;
	
	public Review() {
		
	}
	public Review(Users users,Movie video,String comment,LocalDateTime dates) {
		super();
		this.users = users;
		this.video = video;
//		this.score = score;
		this.comment = comment;
		this.dates = dates;
	}
}
