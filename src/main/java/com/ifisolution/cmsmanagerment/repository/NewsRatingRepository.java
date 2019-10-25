package com.ifisolution.cmsmanagerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifisolution.cmsmanagerment.entities.NewsRating;

@Repository
public interface NewsRatingRepository extends JpaRepository<NewsRating, Integer> {

}
