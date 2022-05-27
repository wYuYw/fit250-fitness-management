package com.ssafy.fitness.model.dao;

import java.util.List;

import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.dto.Video;

public interface UserDao {
	// 사용자 등록
	void insertUser(User user);
	
	// 사용자 조회
	User selectOne(String id);
	
	// 사용자 수정
	void updateUser(User user);
	
	// 사용자 삭제
	void deleteUser(String id);
	
	// 정보 일치 조회
	User selectByInput(User user);
	

	
}
