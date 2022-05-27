package com.ssafy.fitness.model.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitness.model.dao.PerformanceDao;
import com.ssafy.fitness.model.dao.UserDao;
import com.ssafy.fitness.model.dao.VideoDao;
import com.ssafy.fitness.model.dto.Performance;
import com.ssafy.fitness.model.dto.User;
import com.ssafy.fitness.model.dto.Video;
import com.ssafy.fitness.util.SHA256;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private VideoDao videoDao;
	
	@Autowired
	private PerformanceDao performanceDao;
	
	@Autowired
	private SHA256 sha256;
	
	// 사용자 등록
	@Override
	public void registerUser(User user) {
		
		// DB에 저장될 식별자(id)를 UUID 이용하여 생성
		user.setId(UUID.randomUUID()+"");
		
		// 비밀번호 암호화
		try {
			user.setPw(sha256.getHash(user.getPw()));
		} catch (NoSuchAlgorithmException e) {
			// 에러 발생시 대응 작성하기 ☆★☆
			e.printStackTrace();
		}
		
		userDao.insertUser(user);
	}

	// 사용자 조회
	@Override
	public User getUser(String id) {
		return userDao.selectOne(id);
	}

	// 사용자 정보 수정
	@Override
	public void modifyUser(User user) {
		// 비밀번호를 암호화
		try {
			user.setPw(sha256.getHash(user.getPw()));
		} catch (NoSuchAlgorithmException e) {
			// 에러 발생시 대응 작성하기 ☆★☆
			e.printStackTrace();
		}
		userDao.updateUser(user);
	}

	// 사용자 정보 삭제
	@Override
	public void removeUser(String id) {
		userDao.deleteUser(id);
		// 유저가 만든 다른 데이터들도 같이 삭제하거나 다른 처리를 해주려면 여기에 추가로 작성하기
	}

	// 로그인 가능 유무 판단
	@Override
	public User loginOK(User user) {
		// DB에 저장된 암호화된 비밀번호와 비교하기 위해 
		// 클라이언트에서 입력된 비밀번호를 암호화하여 dao로 보냄
		try {
			user.setPw(sha256.getHash(user.getPw()));
		} catch (NoSuchAlgorithmException e) {
			// 에러 발생시 대응 작성하기 ☆★☆
			e.printStackTrace();
		}
		
		return userDao.selectByInput(user);
	}

	
	// 사용자의 관심 부위 영상 조회
	@Override
	public List<Video> getInterestVideoList(User user) {
		return videoDao.selectByUserInterest(user);
	}

	// 사용자가 찜한 영상 조회
	@Override
	public List<Video> getHeartVideoList(String userTableId) {
		return videoDao.selectByUserHeart(userTableId);
	}

	// 기기 연동 상태 변경
	@Override
	public void mounted(User user) {
		userDao.updateUser(user);
	}

	// 사용자 운동 기록
	@Override
	public Performance getUserPerformance(String userTableId) {
		
		return performanceDao.selectByUserTableId(userTableId);
	}

	// 지난달 운동 기록 TOP2 유저 조회
	@Override
	public List<User> getMonthlyTop2() {
		List<User> top2List = new ArrayList<User>();
		
		User u1 = userDao.selectOne(performanceDao.selectMonthlyTop2().get(0).getUserTableId());
		u1.setPw(null);
		User u2 = userDao.selectOne(performanceDao.selectMonthlyTop2().get(1).getUserTableId());
		u2.setPw(null);
		
		top2List.add(u1);
		top2List.add(u2);
		return top2List;
	}

	// 지난달 운동 기록 TOP2 운동 기록 조회
	@Override
	public List<Performance> getMonthlyTop2Performance() {
		return performanceDao.selectMonthlyTop2();
	}

	// 지난달 운동 기록 TOP2 조회
//	@Override
//	public List<HashMap<User, Performance>> getMonthlyTop2() {
//		// top2 정보 담을 리스트
//		List<HashMap<User, Performance>> top2List =  new ArrayList<>();
//		
//		// top1 정보 받아와서 hashmap형태로 만듬
//		Performance user1Performance = performanceDao.selectMonthlyTop2().get(0);
//		User user1 = userDao.selectOne(user1Performance.getUserTableId());
//		HashMap<User, Performance> user1Info = new HashMap<User, Performance>();
//		user1Info.put(user1, user1Performance);
//		
//		// top2 정보 받아와서 hashmap형태로 만듬
//		Performance user2Performance = performanceDao.selectMonthlyTop2().get(1);
//		User user2 = userDao.selectOne(user2Performance.getUserTableId());
//		HashMap<User, Performance> user2Info = new HashMap<User, Performance>();
//		user2Info.put(user2, user2Performance);
//		
//		// 두 정보 list에 담기
//		top2List.add(user1Info);
//		top2List.add(user2Info);
//		return top2List;
//	}

}
