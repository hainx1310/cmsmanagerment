package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifisolution.cmsmanagerment.entities.NewsStatus;

public interface NewsStatusService {
	List<NewsStatus> findAll();

	NewsStatus findById(Integer Id);

	NewsStatus save(NewsStatus newsStatus);

	NewsStatus update(NewsStatus newsStatus, Integer Id);

	ResponseEntity<Object> deleteById(Integer id);
}
