package com.ifisolution.cmsmanagerment.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ifisolution.cmsmanagerment.dto.NewsHeaderDTO;
import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.services.NewsHeaderServices;

@RestController
@RequestMapping(value = "/api")
public class NewsHeaderController {

	@Autowired
	private NewsHeaderServices newsHeaderServices;

	@GetMapping(value = "/news-header")
	public ResponseEntity<List<NewsHeader>> getAllNewsHeader() {
		return ResponseEntity.ok(this.newsHeaderServices.getAllNewsHeader());
	}

	@GetMapping(value = "/news-header/{newsHeaderId}")
	public ResponseEntity<NewsHeader> getNewsHeaderById(@PathVariable("newsHeaderId") int newsHeaderId) {
		return ResponseEntity.ok(this.newsHeaderServices.getNewsHeaderById(newsHeaderId));
	}

	@PostMapping(value = "/news-header")
	public ResponseEntity<NewsHeader> createNewsHeader(@Valid @RequestBody NewsHeaderDTO newsHeaderDTO) {
		return ResponseEntity.ok(this.newsHeaderServices.createNewsHeader(newsHeaderDTO));
	}

	@PutMapping(value = "/news-header/{newsHeaderId}")
	public ResponseEntity<NewsHeader> updateNewsHeader(@PathVariable("newsHeaderId") int newsHeaderId,
			@Valid @RequestBody NewsHeaderDTO newsHeaderDTO) {
		return ResponseEntity.ok(this.newsHeaderServices.updateNewsHeader(newsHeaderId, newsHeaderDTO));
	}

	@DeleteMapping(value = "/news-header/{newsHeaderId}")
	public ResponseEntity<?> deleteNewsHeader(@PathVariable("newsHeaderId") int newsHeaderId) {
		this.newsHeaderServices.deleteNewsHeader(newsHeaderId);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/topic/{topicId}/news-header")
	public ResponseEntity<List<NewsHeader>> getNewsHeaderByTopicId(@PathVariable("topicId") int topicId) {
		return ResponseEntity.ok(this.newsHeaderServices.findNewsHeadersByTopicId(topicId));
	}

	@GetMapping(value = "/status/{statusCode}/news-header")
	public ResponseEntity<List<NewsHeader>> getNewsHeaderByTopicId(@PathVariable("statusCode") String statusCode) {
		return ResponseEntity.ok(this.newsHeaderServices.findNewsHeadersByNewsStatusCode(statusCode));
	}
}
