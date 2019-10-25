package com.ifisolution.cmsmanagerment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.cmsmanagerment.dto.TopicTrackingModel;
import com.ifisolution.cmsmanagerment.entities.Topic;
import com.ifisolution.cmsmanagerment.entities.TopicTracking;
import com.ifisolution.cmsmanagerment.services.impl.TopicServiceImpl;
import com.ifisolution.cmsmanagerment.services.impl.TopicTrackingServicesImpl;

@RestController
public class TopicTrackingController {
	@Autowired
	TopicTrackingServicesImpl topicTrackingServices;
	TopicServiceImpl topicServiceImpl;

	@RequestMapping(value = "/topictracking/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TopicTracking getTopicTracking(@PathVariable("id") int id) {
		return topicTrackingServices.findByID(id);
	}

	@RequestMapping(value = "/topictracking/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteTopicTracking(@PathVariable("id") int id) {
		topicTrackingServices.deleteTopictracking(id);
	}

	@RequestMapping(value = "/topictracking", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void insertTopicTracking(@RequestBody TopicTrackingModel topicTrackingModel) {
		TopicTracking topicTracking = new TopicTracking();
		Topic topic = topicServiceImpl.findByID(topicTrackingModel.getTopicId());
		// set data
		topicTracking.setTopic(topic);
		topicTracking.setTopicName(topicTrackingModel.getTopicName());
		topicTracking.setsubTopicName(topicTrackingModel.getSubTopicName());
		topicTracking.setStatus(topicTrackingModel.getStatus());
		topicTracking.setCreateAt(topicTrackingModel.getCreataAt());
		topicTracking.setDoctorId(topicTrackingModel.getDoctorId());
		topicTracking.setUserId(topicTrackingModel.getUserId());
		topicTracking.setTypeMember(topicTrackingModel.getTypeMember());
		topicTrackingServices.insertTopicTracking(topicTracking);
		// save
		topicTrackingServices.insertTopicTracking(topicTracking);
	}

	@RequestMapping(value = "/topictracking", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void updateTopicTracking(@RequestBody TopicTracking topicTracking) {
		TopicTracking topicTracking = new TopicTracking();
		Topic topic = topicServiceImpl.findByID(topicTrackingModel.getTopicId());
		// set data
		topicTracking.setId(topicTrackingModel.getId());
		topicTracking.setTopic(topic);
		topicTracking.setTopicName(topicTrackingModel.getTopicName());
		topicTracking.setsubTopicName(topicTrackingModel.getSubTopicName());
		topicTracking.setStatus(topicTrackingModel.getStatus());
		topicTracking.setCreateAt(topicTrackingModel.getCreataAt());
		topicTracking.setDoctorId(topicTrackingModel.getDoctorId());
		topicTracking.setUserId(topicTrackingModel.getUserId());
		topicTracking.setTypeMember(topicTrackingModel.getTypeMember());
		topicTrackingServices.insertTopicTracking(topicTracking);
		// update
		topicTrackingServices.updateTopicTracking(topicTracking);
	}
}
