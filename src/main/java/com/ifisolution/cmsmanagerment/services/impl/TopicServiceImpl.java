package com.ifisolution.cmsmanagerment.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.Topic;
import com.ifisolution.cmsmanagerment.repository.TopicRepository;
import com.ifisolution.cmsmanagerment.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicrepository;

	@Override
	public List<Topic> findAll() {

		return topicrepository.findAll();
	}

	@Override
	public Topic findById(Integer Id) {
		Optional<Topic> topic = topicrepository.findById(Id);
		if (!topic.isPresent()) {
			throw new EntityNotFoundException("Not Found Topic with id " + Id);
		}
		Topic topic2 = topic.get();
		return topic2;
	}

	@Override
	public Topic save(Topic topic) {
		Integer id = topic.getId();
		Optional<Topic> topic2 = topicrepository.findById(id);
		if (topic2.isPresent()) {
			throw new EntityNotFoundException("Topic id " + id + " has exist");
		}
		topic.setCreatedAt(new Timestamp(new Date().getTime()));

		return topicrepository.save(topic);
	}

	@Override
	public Topic updateTopic(Topic topic, Integer Id) {
		Optional<Topic> stockTopic = topicrepository.findById(Id);
		Integer idUpdate = topic.getId();
		if (!stockTopic.isPresent()) {
			throw new EntityNotFoundException("Topic id " + Id + " not found");
		}
		if (idUpdate != Id) {
			throw new EntityNotFoundException("not change id");
		}
		Topic stockTopic2 = stockTopic.get();
		Timestamp stockdate=stockTopic2.getCreatedAt();
		topic.setCreatedAt(stockdate);
		return topicrepository.save(topic);
	}

	@Override
	public ResponseEntity<Object> deleteById(Integer Id) {
		Optional<Topic> topic = topicrepository.findById(Id);
		if (!topic.isPresent()) {
			throw new EntityNotFoundException("Not Found Topic with id " + Id);
		}
		Topic topicTracking = topic.get();
		if(!topicTracking.getListTopic().isEmpty()) {
			throw new EntityNotFoundException("Topic Tracking not Empty is Topic Id" + Id);
		}
		if(!topicTracking.getNewsHeader().isEmpty()) {
			throw new EntityNotFoundException("News Header not Empty is Topic Id" + Id);
		}
		topicrepository.deleteById(Id);
		return new ResponseEntity<Object>("Topic id " + Id + " has been deleted", HttpStatus.OK);
	}

}
