package com.ssafy.fitness.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.fitness.model.dto.Performance;
import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.dto.Video;

public interface UserService {
	// 사용자 등록
	void registerUser(User user);
	
	// 사용자 조회
	User getUser(String id);
	
	// 사용자 정보 수정
	void modifyUser(User user);
	
	// 사용자 정보 삭제
	void removeUser(String id);
	
	// 로그인 가능 유무 판단
	User loginOK(User user);
	
	
	// 사용자의 관심 부위 영상 조회
	List<Video> getInterestVideoList(User user);
	
	// 사용자가 찜한 영상 조회
	List<Video> getHeartVideoList(String userTableId);
	
	// 기기 연동 상태 변경
	void mounted(User user);
	
	// 사용자 운동 기록
	Performance getUserPerformance(String userTableId);
	
	// 지난달 운동 기록 TOP2 유저 조회
	List<User> getMonthlyTop2();
	
	// 지난달 운동 기록 TOP2 운동 기록 조회
	List<Performance> getMonthlyTop2Performance();
	
}
