package com.ssafy.fitness.model.service;

import com.ssafy.fitness.model.dto.Heart;
import com.ssafy.fitness.model.dto.Video;

public interface HeartService {
//	// 찜 정보 등록
//	void addHeart(Heart heart);
//	
//	// 찜 정보 삭제
//	void removeHeart(Heart heart);
	
	// 찜 정보 조회 후 찜 등록 혹은 삭제
	Video checkHeart(Heart heart);
}
