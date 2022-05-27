package com.ssafy.fitness.model.service;

import java.util.List;

import com.ssafy.fitness.model.dto.Comment;

public interface CommentService {

	// 해당 영상의 댓글 리스트 조회
	List<Comment> getCommentList(String videoTableId);
	
	// 댓글 달기
	void addComment(Comment comment);
	
	// 댓글 삭제
	void removeComment(String id);
	
	// 댓글 수정
	void modifyComment(Comment comment);
	
}
