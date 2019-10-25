package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsRating;
import com.ifisolution.cmsmanagerment.repository.NewsRatingRepository;
import com.ifisolution.cmsmanagerment.services.INewsRating;

@Service
public class NewsRatingService implements INewsRating {
	@Autowired
	NewsRatingRepository newsRatingRepository;

	@Override
	public NewsRating create(NewsRating newsRating) {
		NewsRating newsRatingTemp = this.getById(newsRating.getId());
		if (newsRatingTemp != null) {
			throw new EntityExistsException("this NewsRating already exist!");
		} else
			return newsRatingRepository.save(newsRating);
	}

	@Override
	public NewsRating getById(int id) {
		NewsRating newsRating = newsRatingRepository.findById(id).isPresent() ? newsRatingRepository.findById(id).get()
				: null;
		return newsRating;
	}

	@Override
	public NewsRating update(NewsRating newsRating) {
		NewsRating newsRatingTemp = this.getById(newsRating.getId());
		if (newsRatingTemp == null) {
			throw new EntityNotFoundException("not found NewsRating with id: " + newsRating.getId());
		} else
			return newsRatingRepository.save(newsRating);

	}

	@Override
	public List<NewsRating> getAll() {
		return newsRatingRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> delete(int id) {
		NewsRating newsRatingTemp = this.getById(id);
		if (newsRatingTemp == null) {
			throw new EntityNotFoundException("not found NewsRating with id: " + id);
		} else {
			newsRatingRepository.deleteById(id);
			return new ResponseEntity<Object>("", HttpStatus.ACCEPTED);
		}
	}

}
