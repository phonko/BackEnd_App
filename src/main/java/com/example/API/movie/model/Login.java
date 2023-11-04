package com.example.API.movie.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//import com.example.API.movie.model.Status;
//import com.example.API.movie.model.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Login")
@Table(
		name = "Login"
)

public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Users users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id",referencedColumnName = "id" ,nullable = false)
	@Fetch(FetchMode.JOIN)
	private  Status status;
	
	public Login() {
		
	}
	public Login(Users users,Status status) {
		super();
		this.users = users;
		this.status = status;
	}
}
