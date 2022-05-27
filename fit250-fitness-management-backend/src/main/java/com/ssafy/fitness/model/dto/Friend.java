package com.ssafy.fitness.model.dto;

import lombok.Data;

@Data
public class Friend {
	private String id;
	private String userTableId1;
	private String userTableId2;
	private String joinDate;
	
	private String friendUserid;
	
	private int calorie;
	private int minute;
}
