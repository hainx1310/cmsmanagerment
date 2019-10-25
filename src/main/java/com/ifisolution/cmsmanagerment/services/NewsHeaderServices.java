package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import com.ifisolution.cmsmanagerment.entities.NewsHeader;

public interface NewsHeaderServices {

	NewsHeader createNewsHeader(NewsHeader newsHeader);

	NewsHeader updateNewsHeader(int newsHeaderId, NewsHeader newsHeader);

	void deleteNewsHeader(int newsHeaderId);

	List<NewsHeader> getAllNewsHeader();
	
	NewsHeader getNewsHeaderById(int newsHeaderId);
}
