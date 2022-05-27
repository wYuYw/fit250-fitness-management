package com.ssafy.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitness.model.dto.Heart;
import com.ssafy.fitness.model.dto.Video;
import com.ssafy.fitness.model.service.HeartService;
import com.ssafy.fitness.model.service.VideoService;

@RestController
@RequestMapping("/api")
public class VideoRestController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private HeartService heartService;
	
	// 전체 영상 조회
	@GetMapping("/video")
//	public ResponseEntity<List<Video>> list (@RequestParam(defaultValue = "") String mode, 
//			@RequestParam(defaultValue = "") String keyword) {
//		
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("mode", mode);
//		params.put("keyword", keyword);
//		return new ResponseEntity<List<Video>>(videoService.getVideoList(params), HttpStatus.OK);
//	}
	public ResponseEntity<List<Video>> list () {
		//System.out.println(videoService.getVideoList().get(0));
		return new ResponseEntity<List<Video>>(videoService.getVideoList(), HttpStatus.OK);
	} 
	
	// 영상 하나 조회
//	@PostMapping("/video/{id}")
	@GetMapping("/videodetail/{id}")
	public ResponseEntity<Video> detail(@PathVariable String id) {
		
		return new ResponseEntity<Video>(videoService.getVideo(id), HttpStatus.OK);
		
		// 에러 처리 하기 ☆★☆
		/*
		try {
			return new ResponseEntity<Board>(boardService.getBoard(id), HttpStatus.OK);
		}catch (Exception e) {
			throw new BoardNotFoundException(id +"번 게시글은 없음당.");		
		}
		 */
	}
	
	// 조건에 맞는 영상 조회 (검색어)
	@GetMapping("/video/{keyword}")
	public ResponseEntity<List<Video>> search(@PathVariable String keyword) {

		return new ResponseEntity<List<Video>>(videoService.getKeywordVideoList(keyword), HttpStatus.OK);

		// 에러 처리 하기 ☆★☆
		/*
		 * try { return new ResponseEntity<Board>(boardService.getBoard(id),
		 * HttpStatus.OK); }catch (Exception e) { throw new BoardNotFoundException(id
		 * +"번 게시글은 없음당."); }
		 */
	}
	
	// 같은 부위 영상 조회 (레벨 기준 영상 추천)
	@PostMapping("/videoLevelRec")
	public ResponseEntity<List<Video>> levelRecommend(@RequestBody Video video) {
		//System.out.println(video);
		return new ResponseEntity<List<Video>>(videoService.getLevelVideoList(video), HttpStatus.OK);
	}

	// 최근 일주일 안에 하트 많이 받은 순으로 3개 조회
	@GetMapping("/videoWeeklyTop3")
	public ResponseEntity<List<Video>> weeklyTop3() {
		return new ResponseEntity<List<Video>>(videoService.getHeartVideoList(), HttpStatus.OK);
	}
	
	// 비디오 heart 
	@PostMapping("/videoHeart")
	public ResponseEntity<Video> clickHeart(@RequestBody Heart heart) {
//		System.out.println(heart);
	
		return new ResponseEntity<Video>(heartService.checkHeart(heart), HttpStatus.OK);
	}
	
}
