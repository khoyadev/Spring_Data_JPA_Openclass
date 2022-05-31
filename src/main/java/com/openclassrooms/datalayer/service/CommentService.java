package com.openclassrooms.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public Optional<Comment> getCommentById(Integer id){
		return commentRepository.findById(id);
	}

	public Iterable<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public void deleteComment(int id) {
		commentRepository.deleteById(id);
	}
	
	public Iterable<Comment> getfindByContentContaining(String expression){
		return commentRepository.findByContentContaining(expression);
	}

}
