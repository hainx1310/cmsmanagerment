package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import com.ifisolution.cmsmanagerment.entities.NewsShare;

public interface NewsShareServices {

	public List<NewsShare> findAllNewsShare();

	public NewsShare create(NewsShare newsShare);

	public NewsShare findByNewsShareId(int id);

	public List<NewsShare> findByNewsHeaderId(int id);

	public void deleteById(int id);

	public NewsShare update(int id, NewsShare newsShare);
	//lay ds newsShare cua headerId
	public Integer countNewsHeaderId(int id);
}
