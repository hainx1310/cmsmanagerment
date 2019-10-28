package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsContent;
import com.ifisolution.cmsmanagerment.repository.NewsContentRepository;
import com.ifisolution.cmsmanagerment.services.NewsContentService;

@Service
public class NewsContentServiceImpl implements NewsContentService {

	@Autowired
	private NewsContentRepository newsscontentrepository;
	
	@Override
	public List<NewsContent> findAll() {

		return newsscontentrepository.findAll();
	}

	@Override
	public NewsContent findById(Integer Id) {
		Optional<NewsContent> newsContent = newsscontentrepository.findById(Id);

		if (!newsContent.isPresent()) {
			throw new EntityNotFoundException("Not Found Content with id " + Id);
		}
		NewsContent newsContent2 = newsContent.get();
		return newsContent2;
	}

	@Override
	public NewsContent save(NewsContent newsContent) {
		Integer id = newsContent.getId();
		Optional<NewsContent> newsContent2 = newsscontentrepository.findById(id);
		if (newsContent2.isPresent()) {
			throw new EntityNotFoundException("Content id " + id + " has exist");
		}
		return newsscontentrepository.save(newsContent);
	}

	@Override
	public NewsContent update(NewsContent newsContent, Integer Id) {
		Optional<NewsContent> stockContent = newsscontentrepository.findById(Id);
		Integer idUpdate = newsContent.getId();
		if (!stockContent.isPresent()) {
			throw new EntityNotFoundException("Content id " + Id + " not found");
		}
		if (idUpdate != Id) {
			throw new EntityNotFoundException("not change id");
		}
		return newsscontentrepository.save(newsContent);
	}

	@Override
	public ResponseEntity<Object> deleteById(Integer Id) {
		Optional<NewsContent> newsContent = newsscontentrepository.findById(Id);
		if (!newsContent.isPresent()) {
			throw new EntityNotFoundException("Not Found Content with id " + Id);
		}
		newsscontentrepository.deleteById(Id);
		return new ResponseEntity<Object>("Content id " + Id + " has been deleted", HttpStatus.OK);
	}

}