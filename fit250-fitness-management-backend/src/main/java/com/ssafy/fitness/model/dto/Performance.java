package com.ssafy.fitness.model.dto;

import lombok.Data;

@Data
public class Performance {
	private String id;
	private String userTableId;
	private int calorie;
	private int heartRate;
	private int bmi;
	private int minute;
	private String fitDate;
	private int days;
	
}
