package com.ssafy.fitness.model.dto;

import lombok.Data;

@Data
public class User {
	private String id;
	private String userid;
	private String pw;
	private String email;
	private String interest1;
	private String interest2;
	private String quote;
	private String privacy;
	private String mounted;
}
