package com.ssafy.fitness.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fitness.model.dao.CommentDao;
import com.ssafy.fitness.model.dto.Comment;

@Service
public class CommentServicImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	// 해당 영상의 댓글 리스트 조회
	@Override
	public List<Comment> getCommentList(String videoTableId) {
		return commentDao.selectComment(videoTableId);
	}

	// 댓글 달기
	@Override
	public void addComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	// 댓글 삭제
	@Override
	public void removeComment(String id) {
		commentDao.deleteComment(id);
	}

	// 댓글 수정
	@Override
	public void modifyComment(Comment comment) {
		commentDao.updateComment(comment);
	}

}
