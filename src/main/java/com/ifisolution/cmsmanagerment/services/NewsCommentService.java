package com.ifisolution.cmsmanagerment.services;

import java.util.List;

import com.ifisolution.cmsmanagerment.entities.NewsComment;

public interface NewsCommentService {

	NewsComment add(NewsComment newsComment);

	NewsComment update(NewsComment newsComment, int id);

	NewsComment delete(int id);

	List<NewsComment> getCommentByHeaderId(int id);
	
	List<NewsComment> getAll();
}
