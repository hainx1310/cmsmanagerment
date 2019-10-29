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

import com.ifisolution.cmsmanagerment.entities.NewsStatus;
import com.ifisolution.cmsmanagerment.services.NewsStatusService;

@RestController
@RequestMapping("/duy")
public class NewsStatusController {
	
	@Autowired
	private NewsStatusService statusservice;

	@GetMapping(value = "/status")
	public List<NewsStatus> getAllStatus() {
		return statusservice.findAll();
	}

	@GetMapping(value = "/status/{id}")
	public NewsStatus getStatusById(@PathVariable Integer id) {
		return statusservice.findById(id);
	}

	@PostMapping(value = "/status")
	public NewsStatus postStatus(@RequestBody NewsStatus status) {
		return statusservice.save(status);
	}

	@PutMapping(value = "/status/{id}")
	public NewsStatus updateStatus(@RequestBody NewsStatus status, @PathVariable Integer id) {
		return statusservice.update(status, id);
	}

	@DeleteMapping(value = "/status/{id}")
	public ResponseEntity deleteStatus(@PathVariable Integer id) {
		return statusservice.deleteById(id);
	}
}
