package com.ssafy.fitness.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitness.model.dto.Performance;
import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.dto.Video;
import com.ssafy.fitness.model.service.UserService;
import com.ssafy.fitness.util.JWTUtil;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	// 사용자 등록
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		userService.registerUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	// 사용자 조회
	@GetMapping("/user/{id}")
		public ResponseEntity<User> detail(@PathVariable String id) {
		// 사용자 비밀번호가 클라이언트에게 전송되지 않게 하기
		User userInfo = userService.getUser(id);
		userInfo.setPw(null);
		return new ResponseEntity<User>(userInfo, HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		
//		System.out.println(user.getUserid() + user.getPw() + user.getEmail());
		
		try {
			// 입력된 정보를 이용하여 데이터베이스에 있는 정보와 일치하는지 확인
			// 일치하면 토큰 생성하여 result에 넣어 반환
			User userInfo = userService.loginOK(user);
			if(userInfo != null) {
				result.put("access-token", jwtUtil.createToken("id", userInfo.getId()));
				result.put("message", SUCCESS);
				result.put("userId", userInfo.getId());
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) { // UnsupportedEncodingException 찾아보기 ☆★☆
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(result, status);
	}
		
	// 사용자 정보 수정
	@PutMapping("/user/{id}")
	public ResponseEntity<String> modify(@RequestBody User user, @PathVariable String id) {
		user.setId(id);
		userService.modifyUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	// 사용자 정보 삭제
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> remove(@PathVariable String id) {
		userService.removeUser(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		
		// 삭제 안됐을 경우 처리 ☆★☆
		// 없는 id가 들어올 수도 있나...? 아무튼 이것도 처리 
	}
	
	
	// 사용자의 관심 부위 영상 조회
	@GetMapping("/userInterest/{userTableId}")
	public ResponseEntity<List<Video>> interestRecommend(@PathVariable String userTableId) {
		User user = userService.getUser(userTableId);
		return new ResponseEntity<List<Video>>(userService.getInterestVideoList(user), HttpStatus.OK);
	}
	
	// 사용자가 찜한 영상 조회
	@GetMapping("/userHeart/{userTableId}")
	public ResponseEntity<List<Video>> heartVideoList(@PathVariable String userTableId) {
		
		return new ResponseEntity<List<Video>>(userService.getHeartVideoList(userTableId), HttpStatus.OK);
	}
	
	// 기기 연동 상태 변경 (기기 연결만 구현)
	@PutMapping("/mounted/{userTableId}")
	public ResponseEntity<User> mounted(@PathVariable String userTableId) {
		User userInfo = userService.getUser(userTableId);
		userInfo.setMounted("Y");
		userService.modifyUser(userInfo);
		userInfo.setPw(null);
		return new ResponseEntity<User>(userInfo, HttpStatus.OK);
	}
	
	// 유저 운동 기록 조회
	@GetMapping("/userPerformance/{userTableId}")
	public ResponseEntity<Performance> userPerformance(@PathVariable String userTableId) {
		
		return new ResponseEntity<Performance>(userService.getUserPerformance(userTableId), HttpStatus.OK);
	}
	
	// 지난달 운동 기록 TOP2 유저 정보 조회
	@GetMapping("/monthlyTop2")
	public ResponseEntity<List<User>> getmonthlyTop2() {
		
		return new ResponseEntity<List<User>>(userService.getMonthlyTop2(),HttpStatus.OK);
	}
	
	// 지난달 운동 기록 TOP2 운동 기록 조회
	@GetMapping("/monthlyTop2Performance")
	public ResponseEntity<List<Performance>> getmonthlyTop2Performance() {
		
		return new ResponseEntity<List<Performance>>(userService.getMonthlyTop2Performance(),HttpStatus.OK);
	}
	
}
