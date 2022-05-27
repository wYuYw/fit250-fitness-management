package com.ssafy.fitness.model.service;

import java.util.List;

import com.ssafy.fitness.model.dto.Friend;
import com.ssafy.fitness.model.dto.User;

public interface FriendService {

	// 친구인 경우
	// 친구 목록 조회 (운동 시간순 정렬)
	List<Friend> getFriendList(Friend friend);
	
	// 친구 삭제
	void removeFriend(Friend friend);
	
	
	// 친구 아닌 경우
	// 친구 외 사용자 중 검색어 포한한  아이디 갖는 사용자 조회
	List<User> getNotFriendList(Friend friend);
	
	// 친구 추가
	void addFriend(Friend friend);
}
