package com.ifisolution.cmsmanagerment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ifisolution.cmsmanagerment.entities.NewsRating;
import com.ifisolution.cmsmanagerment.services.NewsRatingService;

@RestController
@RequestMapping("/api/news-rating")
public class NewsRatingController {
	@Autowired
	NewsRatingService newsRatingService;

	@GetMapping("")
	public ResponseEntity<List<NewsRating>> getAll() {
		List<NewsRating> list = newsRatingService.getAll();
		return new ResponseEntity<List<NewsRating>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@Valid @PathVariable int id) {
		NewsRating newsRating = newsRatingService.getById(id);
		return new ResponseEntity<Object>(newsRating, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody NewsRating newsRating) {
		NewsRating newsRatingTemp = newsRatingService.create(newsRating);
		return new ResponseEntity<Object>(newsRatingTemp, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@Valid @PathVariable int id, @RequestBody NewsRating newsRating) {
		NewsRating newsRatingTemp = newsRatingService.update(id, newsRating);
		return new ResponseEntity<Object>(newsRatingTemp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@Valid @PathVariable int id) {
		ResponseEntity<Object> respone = newsRatingService.delete(id);
		return respone;
	}

	@GetMapping("/{id}/news-header")
	public ResponseEntity<Object> getNewsHeaderByNewsRatingId(@Valid @PathVariable int id) {
		NewsHeader newsHeader = newsRatingService.getNewsHeaderByNewsRatingId(id);
		return new ResponseEntity<Object>(newsHeader, HttpStatus.OK);

	}

	@GetMapping("/news-header/{id}")
	public ResponseEntity<Object> findNewsRatingByNewsHeaderId(@Valid @PathVariable int id) {
		List<NewsRating> newsRatings = newsRatingService.findNewsRatingsByNewsHeaderId(id);
		return new ResponseEntity<Object>(newsRatings, HttpStatus.OK);

	}
}
