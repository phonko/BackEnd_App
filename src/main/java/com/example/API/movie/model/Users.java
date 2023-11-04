package com.example.API.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@RequiredArgsConstructor
@ToString
@Entity(name= "Users")
@Table(
		name = "Users",
		uniqueConstraints = {
				@UniqueConstraint(name = "users_email_unique", columnNames = "email")
		}
)
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	public Users() {
		
	}
	public Users(String name,Integer age,String address,String email,String password) {
		super();
		this.name = name;
		this.age = age;
		this.address= address;
		this.email = email;
		this.password = password;
	}
}
