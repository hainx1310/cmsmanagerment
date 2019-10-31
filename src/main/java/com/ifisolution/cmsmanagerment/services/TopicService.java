package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifisolution.cmsmanagerment.entities.Topic;

public interface TopicService {

	List<Topic> findAll();

	Topic findById(Integer Id);

	Topic save(Topic topic);

	Topic updateTopic(Topic topic, Integer Id);

	ResponseEntity<Object> deleteById(Integer id);
}
