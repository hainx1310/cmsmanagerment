package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.TopicTracking;

@Repository
public interface TopicTrackingRepository extends CrudRepository<TopicTracking, Integer> {

}