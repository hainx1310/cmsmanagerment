package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
