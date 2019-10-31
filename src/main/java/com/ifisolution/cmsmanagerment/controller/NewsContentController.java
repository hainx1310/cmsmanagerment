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

import com.ifisolution.cmsmanagerment.entities.NewsContent;
import com.ifisolution.cmsmanagerment.services.NewsContentService;

@RestController
@RequestMapping("/duy")
public class NewsContentController {

	@Autowired
	private NewsContentService contentservice;

	@GetMapping(value = "/content")
	public List<NewsContent> getAllContent() {
		return contentservice.findAll();
	}

	@GetMapping(value = "/content/{id}")
	public NewsContent getContentById(@PathVariable Integer id) {
		return contentservice.findById(id);
	}

	@PostMapping(value = "/content")
	public NewsContent postContent(@RequestBody NewsContent content) {
		return contentservice.save(content);
	}

	@PutMapping(value = "/content/{id}")
	public NewsContent updateContent(@RequestBody NewsContent content, @PathVariable Integer id) {
		return contentservice.update(content, id);
	}

	@DeleteMapping(value = "/content/{id}")
	public ResponseEntity<Object> deleteContent(@PathVariable Integer id) {
		return contentservice.deleteById(id);
	}

	@GetMapping(value = "/content/header/{id}")
	public List<NewsContent> getContentByIdHeader(@PathVariable int id) {
		return contentservice.findNewsContentsByNewsHeaderId(id);
	}
}
