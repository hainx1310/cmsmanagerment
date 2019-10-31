package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import com.ifisolution.cmsmanagerment.dto.NewsHeaderDTO;
import com.ifisolution.cmsmanagerment.entities.NewsHeader;

public interface NewsHeaderServices {

	NewsHeader createNewsHeader(NewsHeaderDTO newsHeaderDTO);

	NewsHeader updateNewsHeader(int newsHeaderId, NewsHeaderDTO newsHeaderDTO);

	void deleteNewsHeader(int newsHeaderId);

	List<NewsHeader> getAllNewsHeader();

	NewsHeader getNewsHeaderById(int newsHeaderId);

	List<NewsHeader> findNewsHeadersByTopicId(int topicId);

	List<NewsHeader> findNewsHeadersByNewsStatusCode(String statusCode);
}
