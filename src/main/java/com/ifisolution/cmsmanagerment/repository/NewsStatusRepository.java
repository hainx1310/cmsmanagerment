package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsStatus;

@Repository
public interface NewsStatusRepository extends JpaRepository<NewsStatus, Integer> {
	
	NewsStatus findByStatusLike(String statusCode);
}
