package com.ssafy.fitness.model.dao;

import java.util.List;

import com.ssafy.fitness.model.dto.Performance;

public interface PerformanceDao {

	// 운동 기록 등록
//	void insertPerformance(Performance performance);

	// 운동 기록 삭제	
	
	// 운동 기록 조회
	Performance selectByUserTableId(String userTableId);
	
	// 지난달 운동 기록 TOP2 조회
	List<Performance> selectMonthlyTop2();
}
