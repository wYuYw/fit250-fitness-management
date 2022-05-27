package com.ssafy.fitness.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitness.model.dao.VideoDao;
import com.ssafy.fitness.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao videoDao;
	
	// 전체 영상 조회
	@Override
	public List<Video> getVideoList() {
		return videoDao.selectAll();
	}

	// 영상 하나 조회
	@Override
	public Video getVideo(String id) {
		// 해당 영상의 조회수 하나 증가
		videoDao.updateVideo(id);
		// id에 해당하는 영상 정보
		Video video = videoDao.selectOne(id);
		
		return video;
	}

	// 조건에 맞는 영상 조회 (검색어)
	@Override
	public List<Video> getKeywordVideoList(String keyword) {
		return videoDao.selectByKeyword(keyword);
	}
	
	// 같은 부위 영상 조회 (레벨 기준 영상 추천)
	@Override
	public List<Video> getLevelVideoList(Video video) {
		return videoDao.selectByLevel(video);
	}
	
	// 최근 일주일 안에 하트 많이 받은 순으로 3개 조회
	@Override
	public List<Video> getHeartVideoList() {
		return videoDao.selectHeartTop3();
	}

}
