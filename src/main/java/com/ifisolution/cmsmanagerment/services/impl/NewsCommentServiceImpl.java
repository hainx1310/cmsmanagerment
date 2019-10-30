package com.ifisolution.cmsmanagerment.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.entities.NewsComment;
import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.repository.NewsCommentRepository;
import com.ifisolution.cmsmanagerment.repository.NewsHeaderRepository;
import com.ifisolution.cmsmanagerment.services.NewsCommentService;

@Service
@Configurable
//@Transactional
public class NewsCommentServiceImpl implements NewsCommentService {

	@Autowired
	private NewsCommentRepository newsCommentRepository;

	@Autowired
	private NewsHeaderRepository newsHeaderRepository;

	@Override
	public NewsComment add(NewsComment newsComment) {
		NewsHeader currentNewsHeader = newsHeaderRepository.findById(newsComment.getNewsHeader().getId())
				.orElseThrow(() -> new EntityNotFoundException("Not found NewsHeader"));
		newsComment.setNewsHeader(currentNewsHeader);
		newsComment.setCreatedAt(new Timestamp(new Date().getTime()));
		return newsCommentRepository.save(newsComment);
	}

	@Override
	public NewsComment update(NewsComment newsComment, int id) {
		NewsComment currentcomment = newsCommentRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("comment doesn't exist"));
		NewsHeader currentNewsHeader = newsHeaderRepository.findById(newsComment.getNewsHeader().getId())
				.orElseThrow(() -> new EntityNotFoundException("Not found NewsHeader"));
		currentcomment.setDoctorId(newsComment.getDoctorId());
		currentcomment.setEmail(newsComment.getEmail());
		currentcomment.setName(newsComment.getName());
		newsComment.setNewsHeader(currentNewsHeader);
		currentcomment.setStatusPublish(newsComment.isStatusPublish());
		currentcomment.setTypeMember(newsComment.getTypeMember());
		currentcomment.setUserId(newsComment.getUserId());
		NewsComment result = newsCommentRepository.save(currentcomment);
		return result;
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
		if (newsCommentRepository.getCommentsByHeaderId(id) == null) {
			throw new EntityNotFoundException("There are no comments for this article");
		}
		return newsCommentRepository.getCommentsByHeaderId(id);
	}

	@Override
	public List<NewsComment> getAll() {
		if(newsCommentRepository.findAll() == null) {
			throw new EntityNotFoundException("Not found");
		}
		return newsCommentRepository.findAll();
	}

}