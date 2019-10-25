package com.ifisolution.cmsmanagerment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.cmsmanagerment.entities.Topic;
import com.ifisolution.cmsmanagerment.services.TopicService;

@RestController
@RequestMapping("/duy")
public class TopicController {
	@Autowired
	private TopicService topicservice;

	@GetMapping(value = "/topic")
	public List<Topic> getAllTopic() {
		return topicservice.findAll();
	}

	@GetMapping(value = "/topic/{id}")
	public Topic getTopicById(@PathVariable Integer id) {
		return topicservice.findById(id);
	}

	@PostMapping(value = "/topic")
	public Topic postTopic(@RequestBody Topic topic) {
		return topicservice.save(topic);
	}

	@PutMapping(value = "/topic/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable Integer Id) {
		return topicservice.updateTopic(topic, Id);
	}

	@DeleteMapping(value = "/topic/{id}")
	public ResponseEntity deleteTopic(@PathVariable Integer Id) {
		return topicservice.deleteById(Id);
	}
}
