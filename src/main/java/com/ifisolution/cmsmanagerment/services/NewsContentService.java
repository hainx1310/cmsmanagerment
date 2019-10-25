package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifisolution.cmsmanagerment.entities.NewsContent;

public interface NewsContentService {
	List<NewsContent> findAll();

	NewsContent findById(Integer Id);

	NewsContent save(NewsContent newsContent);

	NewsContent update(NewsContent newsContent, Integer Id);

	ResponseEntity deleteById(Integer id);
}
