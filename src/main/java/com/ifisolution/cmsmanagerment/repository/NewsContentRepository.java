package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.cmsmanagerment.entities.NewsContent;

public interface NewsContentRepository extends JpaRepository<NewsContent, Integer> {

}
