package com.ifisolution.cmsmanagerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsComment;

@Repository
public interface NewsCommentRepository extends JpaRepository<NewsComment, Integer> {
	@Query("SELECT nc FROM NewsComment nc  WHERE nc.newsHeader.id =:id")
	List<NewsComment> getCommentsByHeaderId(@Param("id") int id);
}
