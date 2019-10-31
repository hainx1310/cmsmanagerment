package com.ifisolution.cmsmanagerment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.cmsmanagerment.entities.NewsComment;
import com.ifisolution.cmsmanagerment.services.NewsCommentService;

@RestController
@RequestMapping(value = "/newscomment")
public class NewsCommentController {
	@Autowired
	private NewsCommentService newsCommentService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<NewsComment>> getAll() {
		return ResponseEntity.ok(newsCommentService.getAll());
	}
	@GetMapping(value = "/comment/{id}")
	public ResponseEntity<List<NewsComment>> getCommentByHeader(@PathVariable("id") int id) {
		return ResponseEntity.ok(newsCommentService.getCommentByHeaderId(id));
	}

	@PostMapping(value = "")
	public ResponseEntity<NewsComment> addComment(@RequestBody NewsComment newsComment) {
		return ResponseEntity.ok(newsCommentService.add(newsComment));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<NewsComment> updateComment(@RequestBody NewsComment newsComment, @PathVariable("id") int id) {
		return ResponseEntity.ok(newsCommentService.update(newsComment, id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<NewsComment> deleteComment(@PathVariable("id") int id) {
		return ResponseEntity.ok(newsCommentService.delete(id));
	}
}
