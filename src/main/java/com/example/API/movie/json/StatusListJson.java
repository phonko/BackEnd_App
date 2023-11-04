package com.example.API.movie.json;

import java.util.ArrayList;
import java.util.List;

import com.example.API.movie.json.StatusListJson;
import com.example.API.movie.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusListJson {
	private Long id;
	private String name;
	
	public static StatusListJson packJson(Status status) {
		StatusListJson slj = new StatusListJson();
		slj.setId(status.getId());
		slj.setName(status.getName());
		return slj;
	}
	public static List<StatusListJson> packJsons(List<Status>sta){
		List<StatusListJson> slj = new ArrayList<StatusListJson>();
		for(Status status : sta) {
			slj.add(packJson(status));
		}
		return slj;
	}
}
