package com.ifisolution.cmsmanagerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsHeader;

@Repository
public interface NewsHeaderRepository extends JpaRepository<NewsHeader, Integer>{

	List<NewsHeader> findNewsHeadersByTopicId(int topicId);
	
	List<NewsHeader> findNewsHeadersByNewsStatusCode(String statusCode);
}
