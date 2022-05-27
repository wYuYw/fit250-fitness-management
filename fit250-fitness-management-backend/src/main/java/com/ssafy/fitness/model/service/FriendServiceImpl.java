package com.ssafy.fitness.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitness.model.dao.FriendDao;
import com.ssafy.fitness.model.dto.Friend;
import com.ssafy.fitness.model.dto.User;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendDao friendDao;
	
	// 친구인 경우
	// 친구 목록 조회 (운동 시간순 정렬)
	@Override
	public List<Friend> getFriendList(Friend friend) {
		return friendDao.selectAllFriend(friend);
	}

	// 친구 삭제
	@Override
	public void removeFriend(Friend friend) {
		friendDao.deleteFriend(friend);
	}

	
	// 친구 아닌 경우
	// 친구 외 사용자 중 검색어 포한한  아이디 갖는 사용자 조회
	@Override
	public List<User> getNotFriendList(Friend friend) {
		List<User> list = friendDao.selectAllNotFriend(friend);
		// 각 유저 정보 중 비밀번호는 null로 바꿔서 비밀번호가 클라이언트로 전송되지 않게 함
		for(int i=0; i<list.size(); i++) {
			list.get(i).setPw(null);
		}
		return list;
	}

	// 친구 추가
	@Override
	public void addFriend(Friend friend) {
		friendDao.insertFriend(friend);
	}

}
