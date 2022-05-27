package com.ssafy.fitness.model.dao;

import com.ssafy.fitness.model.dto.Heart;

public interface HeartDao {
	
	// 찜 정보 등록
	void insertHeart(Heart heart);
	
	// 찜 정보 삭제
	void deleteHeart(Heart heart);
	
	// 찜 정보 조회
	Heart selectHeart(Heart heart);

	
}
