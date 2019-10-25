package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsComment;
import com.ifisolution.cmsmanagerment.repository.NewsCommentRepository;
import com.ifisolution.cmsmanagerment.services.NewsCommentService;

@Service
@Configurable
@Transactional
public class NewsCommentServiceImpl implements NewsCommentService {

	@Autowired
	private NewsCommentRepository newsCommentRepository;

	@Override
	public NewsComment add(NewsComment newsComment) {

		return newsCommentRepository.save(newsComment);
	}

	@Override
	public NewsComment update(NewsComment newsComment, int id) {
		NewsComment currentcomment = newsCommentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("comment doesn't exist"));
		currentcomment.setCreatedAt(newsComment.getCreatedAt());
		currentcomment.setDoctorId(newsComment.getDoctorId());
		currentcomment.setEmail(newsComment.getEmail());
		currentcomment.setName(newsComment.getName());
		currentcomment.setNewsHeader(newsComment.getNewsHeader());
		currentcomment.setStatusPublish(newsComment.isStatusPublish());
		currentcomment.setTypeMember(newsComment.getTypeMember());
		currentcomment.setUserId(newsComment.getUserId());
		newsCommentRepository.save(currentcomment);
		return currentcomment;
	}

	@Override
	public NewsComment delete(int id) {
		NewsComment currentNewsComment = newsCommentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Not found"));
		newsCommentRepository.deleteById(id);
		return currentNewsComment;
	}

	@Override
	public List<NewsComment> getCommentByHeaderId(int id) {
		if (newsCommentRepository.getCommentsByHeaderId(id).size() == 0) {
			throw new EntityNotFoundException("There are no comments for this article");
		}
		return newsCommentRepository.getCommentsByHeaderId(id);
	}

}