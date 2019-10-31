package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsContent;
import com.ifisolution.cmsmanagerment.entities.TopicTracking;
import com.ifisolution.cmsmanagerment.repository.TopicTrackingRepository;
import com.ifisolution.cmsmanagerment.services.TopicTrackingServices;
@Service
@Configurable
@Transactional
public class TopicTrackingServicesImpl implements TopicTrackingServices {

	@Autowired
	TopicTrackingRepository topicTrackingRepository;

	@Override
	public List<TopicTracking> findAll() {
		return (List<TopicTracking>) topicTrackingRepository.findAll();
	}

	@Override
	public TopicTracking findByID(int id) {
		return topicTrackingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
	}

	@Override
	public TopicTracking insertTopicTracking(TopicTracking tp) {
		return topicTrackingRepository.save(tp);
	}

	@Override
	public ResponseEntity<Object> deleteTopictracking(int id) {
		Optional<TopicTracking> tracking = topicTrackingRepository.findById(id);
		if (!tracking.isPresent()) {
			throw new EntityNotFoundException("Not Found Content with id " + id);
		}
		topicTrackingRepository.deleteById(id);
		return new ResponseEntity<Object>("Content id " + id + " has been deleted", HttpStatus.OK);
	}

	@Override
	public TopicTracking updateTopicTracking(TopicTracking tp) {
		TopicTracking tps = topicTrackingRepository.findById(tp.getId())
				.orElseThrow(() -> new EntityNotFoundException("Not Found"));
		return topicTrackingRepository.save(tp);
	}

}