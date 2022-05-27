package com.ssafy.fitness.model.dto;

import lombok.Data;

@Data
public class Video {
	private String id;
	private String videoid;
	private String url;
	private String title;
	private String channelName;
	private String part;
	private int level;
	private String description;
	private String thumbnail;
	private String uploadDate;
	private int viewCnt;
	private int countHeart;
}
