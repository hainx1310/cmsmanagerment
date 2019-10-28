package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsStatus;
import com.ifisolution.cmsmanagerment.repository.NewsStatusRepository;
import com.ifisolution.cmsmanagerment.services.NewsStatusService;

@Service
public class NewsStatusServiceImpl implements NewsStatusService {

	@Autowired
	private NewsStatusRepository newsstatusrepository;

	@Override
	public List<NewsStatus> findAll() {

		return newsstatusrepository.findAll();
	}

	@Override
	public NewsStatus findById(Integer Id) {
		Optional<NewsStatus> newsStatus = newsstatusrepository.findById(Id);

		if (!newsStatus.isPresent()) {
			throw new EntityNotFoundException("Not Found Status with id " + Id);
		}
		NewsStatus newsStatus2 = newsStatus.get();
		return newsStatus2;
	}

	@Override
	public NewsStatus save(NewsStatus newsStatus) {
		Integer id = newsStatus.getId();
		Optional<NewsStatus> newsStatus2 = newsstatusrepository.findById(id);
		if (newsStatus2.isPresent()) {
			throw new EntityNotFoundException("Topic id " + id + " has exist");

		}
		return newsstatusrepository.save(newsStatus);
	}

	@Override
	public NewsStatus update(NewsStatus newsStatus, Integer Id) {
		Optional<NewsStatus> stockStatus = newsstatusrepository.findById(Id);
		Integer idUpdate = newsStatus.getId();
		if (!stockStatus.isPresent()) {
			throw new EntityNotFoundException("Status id " + Id + " not found");
		}
		if (idUpdate != Id) {
			throw new EntityNotFoundException("not change id");
		}
		return newsstatusrepository.save(newsStatus);
	}

	@Override
	public ResponseEntity<Object> deleteById(Integer Id) {
		Optional<NewsStatus> newsStatus = newsstatusrepository.findById(Id);
		if (!newsStatus.isPresent()) {
			throw new EntityNotFoundException("Not Found Status with id " + Id);
		}
		newsstatusrepository.deleteById(Id);
		return new ResponseEntity<Object>("Status id " + Id + " has been deleted", HttpStatus.OK);
	}

}
