package com.ssafy.fitness.model.dao;

import java.util.List;

import com.ssafy.fitness.model.dto.Friend;
import com.ssafy.fitness.model.dto.User;

public interface FriendDao {
	
	// 친구인 경우
	// 친구 목록 조회 (검색어 포함)
	List<Friend> selectAllFriend(Friend friend);
	
	// 친구 목록 중 검색어를 포함하는 userid 갖는 친구 조회 
//	List<Friend> selectKeywordFriend(String keyword);
	
	// 친구 목록 조회 (운동 기록도 같이)
//	List<Friend> selectAllFriend();
	
//	// 친구 확인 조회
//	// select문도 int로 반환하면 행 개수가 넘어오나? ☆★☆
//	Friend selectOne(Friend friend);
	
	// 친구 삭제
	void deleteFriend(Friend friend);
	
	// 친구 아닌 경우
	// 친구 외 사용자 중 검색어 포한한  아이디 갖는 사용자 조회
	List<User> selectAllNotFriend(Friend friend);
	
	// 친구 추가
	void insertFriend(Friend friend);
	
}
