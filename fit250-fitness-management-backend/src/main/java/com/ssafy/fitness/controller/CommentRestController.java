package com.ssafy.fitness.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fitness.model.dto.Comment;
import com.ssafy.fitness.model.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentRestController {
	
	@Autowired
	private CommentService commentService;
	
	// 해당 영상의 댓글 리스트 조회
	@GetMapping("/comment/{videoTableId}")
	public ResponseEntity<List<Comment>> commentList(@PathVariable String videoTableId) {
		
		return new ResponseEntity<List<Comment>>(commentService.getCommentList(videoTableId), HttpStatus.OK);
	}
	
	// 댓글 달기
	@PostMapping("/comment")
	public ResponseEntity<List<Comment>> addComment(@RequestBody Comment comment) {
		comment.setId(UUID.randomUUID()+"");
		commentService.addComment(comment);
		
		return new ResponseEntity<List<Comment>>(commentService.getCommentList(comment.getVideoTableId()), HttpStatus.OK);
	}
	
	// 댓글 삭제
	@PostMapping("/removecomment")
	public ResponseEntity<List<Comment>> removeComment(@RequestBody Comment comment) {

		commentService.removeComment(comment.getId());
		return new ResponseEntity<List<Comment>>(commentService.getCommentList(comment.getVideoTableId()), HttpStatus.OK);
	}
	
	// 댓글 수정
	@PostMapping("/modifycomment")
	public ResponseEntity<List<Comment>> modifyComment(@RequestBody Comment comment) {

		commentService.modifyComment(comment);
		return new ResponseEntity<List<Comment>>(commentService.getCommentList(comment.getVideoTableId()), HttpStatus.OK);
	}
}
