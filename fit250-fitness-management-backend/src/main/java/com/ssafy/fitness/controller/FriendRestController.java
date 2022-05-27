package com.ssafy.fitness.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitness.model.dto.Friend;
import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.service.FriendService;

@RestController
@RequestMapping("/api")
public class FriendRestController {

	@Autowired
	private FriendService friendService;
	
	
	// 친구인 경우
	// 친구 목록 조회 (운동 시간순 정렬)
	// userTableId1 : 내 id(식별자),   userTableId2 : 검색 키워드
	@PostMapping("/friend")
	public ResponseEntity<List<Friend>> friendList(@RequestBody Friend friend) {
		return new ResponseEntity<List<Friend>>(friendService.getFriendList(friend), HttpStatus.OK);
	}
	
//	// 검색한 친구 목록 조회 
//	// userTableId1 : 내 id(식별자),   userTableId2 : 검색 키워드
//	@PostMapping("/searchFriend")
//	public ResponseEntity<List<Friend>> searchFriendList(@RequestBody Friend friend) {
//		return new ResponseEntity<List<Friend>>(friendService.getFriendList(friend), HttpStatus.OK);
//	}
	
	
	// 친구 삭제
	// userTableId1 : 내 식별자(id), userTableId2 : 삭제할 친구 식별자(id)
	@PostMapping("/removefriend")
	public ResponseEntity<List<Friend>> remove(@RequestBody Friend friend) {
		friendService.removeFriend(friend);
		
		friend.setUserTableId2(null);
		return new ResponseEntity<List<Friend>>(friendService.getFriendList(friend), HttpStatus.OK);
	}
	

	
	// 친구 아닌 경우
	// 친구 외 사용자 중 검색어 포한한  아이디 갖는 사용자 조회
	// userTableId1 : 내 id(식별자),   userTableId2 : 검색 키워드
	@PostMapping("/notfriend")
	public ResponseEntity<List<User>> notFriendList(@RequestBody Friend friend) {
		
		return new ResponseEntity<List<User>>(friendService.getNotFriendList(friend), HttpStatus.OK);
	}
	
	
	// 친구 추가
	@PostMapping("/addfriend")
	public ResponseEntity<List<Friend>> add(@RequestBody Friend friend) {
		friend.setId(UUID.randomUUID()+"");
		friendService.addFriend(friend);
		
		friend.setUserTableId2(null);
		return new ResponseEntity<List<Friend>>(friendService.getFriendList(friend), HttpStatus.OK);
	}
	
}
