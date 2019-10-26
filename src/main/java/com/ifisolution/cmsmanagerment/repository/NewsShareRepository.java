package com.ifisolution.cmsmanagerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsShare;

@Repository
public interface NewsShareRepository extends JpaRepository<NewsShare, Integer>{
	List<NewsShare> findNewsSharesByNewsHeaderId(int id);

}
