package com.ssafy.fitness.model.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitness.model.dao.HeartDao;
import com.ssafy.fitness.model.dao.VideoDao;
import com.ssafy.fitness.model.dto.Heart;
import com.ssafy.fitness.model.dto.Video;

@Service
public class HeartServiceImpl implements HeartService{

	@Autowired
	private HeartDao heartDao;
	
	@Autowired
	private VideoDao videoDao;

	@Override
	public Video checkHeart(Heart heart) {
		// heart 테이블에서 현재 들어온 찜 클릭 정보 (uId, vId) 있나 확인
		Heart h = heartDao.selectHeart(heart);
		// 찜 클릭 당한 영상 정보 가져오기
		Video v = videoDao.selectOne(heart.getVideoId());
		if(h != null) { // 있는 데이터일 경우
			// heart 테이블에 있는 데이터 삭제
			heartDao.deleteHeart(heart);
			// 해당 영상의 찜 개수 하나 감소
			v.setCountHeart(v.getCountHeart()-1);
		} else { // 없는 데이터일 경우
			heart.setId(UUID.randomUUID()+"");
			// heart 테이블에 데이터 추가
			heartDao.insertHeart(heart);
			// 해당 영상의 찜 개수 하나 증가
			v.setCountHeart(v.getCountHeart()+1);
		}
		
		// 해당 영상 정보 저장
		videoDao.updateCountHeart(v);
		
		return videoDao.selectOne(v.getId());
	}
	
}
