package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.entities.NewsRating;

public interface NewsRatingService {
	public NewsRating create(NewsRating newsRating);

	public NewsRating getById(int id);

	public NewsRating update(int id, NewsRating newsRating);

	public List<NewsRating> getAll();

	public ResponseEntity<Object> delete(int id);

	public NewsHeader getNewsHeaderByNewsRatingId(int newsRatingId);

	public List<NewsRating> findNewsRatingsByNewsHeaderId(int newsHeaderId);
}
