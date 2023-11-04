package com.example.API.movie.json;

import java.util.ArrayList;
import java.util.List;

import com.example.API.movie.model.Login;
import com.example.API.movie.model.Status;
import com.example.API.movie.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginListJson {
	private Long id;
	private Users users;
	private  Status status;
	
	public static LoginListJson packJson(Login login) {
		LoginListJson llj = new LoginListJson();
		llj.setId(login.getId());
		llj.setUsers(login.getUsers());
		llj.setStatus(login.getStatus());
		return llj;
	}
	public static List<LoginListJson> packJsons(List<Login>lg){
		List<LoginListJson> llj = new ArrayList<LoginListJson>();
		for(Login login : lg) {
			llj.add(packJson(login));
		}
		return llj;
	}
}
