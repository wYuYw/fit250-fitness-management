package com.ssafy.fitness.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.dto.Video;

public interface VideoDao {
	
	// 전체 영상 조회
	List<Video> selectAll();
	// 영상 목록 조회
//	List<Video> selectAll(HashMap<String, String> parmas);
	
	// 영상 조회
	Video selectOne(String id);
	
	// 영상 조회수 수정
	void updateVideo(String id);
	
	// 조건에 맞는 영상 조회 (검색어)
	List<Video> selectByKeyword(String keyword);
	
	// 조건에 맞는 영상 조회 (운동 부위 카테고리)
//	List<Video> selectByPart(String part);
	
	// 관심 분야 관련 영상 조회
//	List<Video> selectByInterest();
	
	// 같은 부위 영상 조회 (레벨 기준 영상 추천)
	List<Video> selectByLevel(Video video);
	
	// 최근 일주일 안에 하트 많이 받은 순으로 3개 조회
	List<Video> selectHeartTop3();
	
	// 영상 찜 개수 수정
	void updateCountHeart(Video video);
	
	
	// 사용자의 관심 부위 영상 조회
	List<Video> selectByUserInterest(User user);
	
	// 사용자가 찜한 영상 조회
	List<Video> selectByUserHeart(String userTableId);
	
	
}
