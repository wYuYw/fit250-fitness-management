package com.ssafy.fitness.model.dao;

import java.util.List;

import com.ssafy.fitness.model.dto.Comment;

public interface CommentDao {

	// 댓글 리스트 조회
	List<Comment> selectComment(String videoTableId);
	
	// 댓글 추가
	void insertComment(Comment comment);
	
	// 댓글 삭제
	void deleteComment(String id);
	
	// 댓글 수정
	void updateComment(Comment comment);

}
