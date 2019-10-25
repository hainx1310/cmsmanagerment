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

import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.services.NewsHeaderServices;

@RestController
@RequestMapping(value = "/news-header")
public class NewsHeaderController {

	@Autowired
	private NewsHeaderServices newsHeaderServices;

	@GetMapping(value = "")
	public ResponseEntity<List<NewsHeader>> getAllNewsHeader() {
		return ResponseEntity.ok(this.newsHeaderServices.getAllNewsHeader());
	}

	@GetMapping(value = "/{newsHeaderId}")
	public ResponseEntity<NewsHeader> getNewsHeaderById(int newsHeaderId) {
		return ResponseEntity.ok(this.newsHeaderServices.getNewsHeaderById(newsHeaderId));
	}

	@PostMapping(value = "")
	public ResponseEntity<NewsHeader> createNewsHeader(@RequestBody NewsHeader newsHeader) {
		return ResponseEntity.ok(this.newsHeaderServices.createNewsHeader(newsHeader));
	}

	@PutMapping(value = "/{newsHeaderId}")
	public ResponseEntity<NewsHeader> updateNewsHeader(@PathVariable("newsHeaderId") int newsHeaderId,
			@RequestBody NewsHeader newsHeader) {
		return ResponseEntity.ok(this.newsHeaderServices.updateNewsHeader(newsHeaderId, newsHeader));
	}

	@DeleteMapping(value = "/{newsHeaderId}")
	public ResponseEntity<?> deleteNewsHeader(@PathVariable("newsHeaderId") int newsHeaderId) {
		this.newsHeaderServices.deleteNewsHeader(newsHeaderId);
		return ResponseEntity.ok().build();
	}
}
