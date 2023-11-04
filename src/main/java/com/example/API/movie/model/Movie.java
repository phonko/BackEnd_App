package com.example.API.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Movie")
@Table(
		name = "Movie"
)
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "imgage", nullable = false)
	private String imgage;
	
	@Column(name = "video", nullable = false)
	private String video;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	
	public Movie() {
		
	}
	public Movie(String name,String imgage,String video,String type,String description) {
		super();
		this.name = name;
		this.imgage = imgage;
		this.video = video;
		this.type = type;
		this.description = description;
	}
}
