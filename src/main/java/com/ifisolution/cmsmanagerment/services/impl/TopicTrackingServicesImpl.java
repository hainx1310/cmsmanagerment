package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifisolution.cmsmanagerment.entities.TopicTracking;
import com.ifisolution.cmsmanagerment.repository.TopicTrackingRepository;
import com.ifisolution.cmsmanagerment.services.TopicTrackingServices;

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
	public void deleteTopictracking(int id) {
		topicTrackingRepository.deleteById(id);

	}

	@Override
	public TopicTracking updateTopicTracking(TopicTracking tp) {
		TopicTracking tps = topicTrackingRepository.findById(tp.getId())
				.orElseThrow(() -> new EntityNotFoundException("Not Found"));
		return topicTrackingRepository.save(tp);
	}

}