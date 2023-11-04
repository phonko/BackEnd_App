package com.example.API.movie.json;

import java.util.ArrayList;
import java.util.List;

import com.example.API.movie.json.UsersListJson;
import com.example.API.movie.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersListJson {
	
	private long id;
	private String name;
	private Integer age;
	private String address;
	private String email;
	private String password;
	
	public static UsersListJson packJson(Users users) {
		UsersListJson ulj = new UsersListJson();
		ulj.setId(users.getId());
		ulj.setName(users.getName());
		ulj.setAge(users.getAge());
		ulj.setAddress(users.getAddress());
		ulj.setEmail(users.getEmail());
		ulj.setPassword(users.getPassword());
		return ulj;
	}
	public static List<UsersListJson> packJsons(List<Users>us){
		List<UsersListJson> ulj = new ArrayList<UsersListJson>();
		for(Users users : us) {
			ulj.add(packJson(users));
		}
		return ulj;
	}
}
