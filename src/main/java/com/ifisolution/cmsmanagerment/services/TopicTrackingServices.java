package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import com.ifisolution.cmsmanagerment.entities.TopicTracking;

public interface TopicTrackingServices {
	List<TopicTracking> findAll();

	TopicTracking findByID(int id);

	TopicTracking insertTopicTracking(TopicTracking tp);

	void deleteTopictracking(int id);

	TopicTracking updateTopicTracking(TopicTracking tp);
}
