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

import com.ifisolution.cmsmanagerment.entities.NewsShare;
import com.ifisolution.cmsmanagerment.services.NewsShareServices;

@RestController
@RequestMapping(path = "/news-share")
public class NewsShareController {
	@Autowired
	private NewsShareServices newsShareService;

	@GetMapping(path = "")
	public ResponseEntity<List<NewsShare>> findAll(){
		return ResponseEntity.ok(newsShareService.findAllNewsShare());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<NewsShare> findById(@PathVariable int id){
		return ResponseEntity.ok(newsShareService.findByNewsShareId(id));

	}

	@GetMapping(path = "/get-by-news-header-id/{id}")
	public ResponseEntity<List<NewsShare>> findByNewsHeaderId(@PathVariable int id){
		return ResponseEntity.ok(newsShareService.findByNewsHeaderId(id));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		newsShareService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<NewsShare> update(@PathVariable int id, @RequestBody NewsShare newsShare){
		return ResponseEntity.ok(newsShareService.update(id,newsShare));
	}

	@PostMapping(path = "/add")
	public ResponseEntity<NewsShare> create(@RequestBody NewsShare newsShare){
		return ResponseEntity.ok(newsShareService.create(newsShare));
	}
}

