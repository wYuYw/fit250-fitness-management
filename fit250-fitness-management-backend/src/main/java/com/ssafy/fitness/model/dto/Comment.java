package com.ssafy.fitness.model.dto;

import lombok.Data;

@Data
public class Comment {
	private String id;
	private String userTableId;
	private String videoTableId;
	private String regDate;
	private String content;
	
	private String userid;
}
