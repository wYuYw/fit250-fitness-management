package com.ssafy.fitness.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.fitness.model.dto.Video;

public interface VideoService {
	
	// 전체 영상 조회
	List<Video> getVideoList();
//	List<Video> getVideoList(HashMap<String, String> parmas);
	
	// 영상 하나 조회
	Video getVideo(String id);
	
	// 조건에 맞는 영상 조회 (검색어)
	List<Video> getKeywordVideoList(String keyword);
	
	// 같은 부위 영상 조회 (레벨 기준 영상 추천)
	List<Video> getLevelVideoList(Video video);
	
	// 최근 일주일 안에 하트 많이 받은 순으로 3개 조회
	List<Video> getHeartVideoList();

}
