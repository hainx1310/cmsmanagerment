package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsHeader;

@Repository
public interface NewsHeaderRepository extends JpaRepository<NewsHeader, Integer>{

}
