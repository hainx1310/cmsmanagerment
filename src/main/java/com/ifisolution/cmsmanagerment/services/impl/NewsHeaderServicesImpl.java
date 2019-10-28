package com.ifisolution.cmsmanagerment.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ifisolution.cmsmanagerment.common.CommonConstant;
import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.entities.NewsStatus;
import com.ifisolution.cmsmanagerment.entities.Topic;
import com.ifisolution.cmsmanagerment.repository.NewsHeaderRepository;
import com.ifisolution.cmsmanagerment.repository.NewsStatusRepository;
import com.ifisolution.cmsmanagerment.repository.TopicRepository;
import com.ifisolution.cmsmanagerment.services.NewsHeaderServices;

@Service
@Configurable
@Transactional
public class NewsHeaderServicesImpl implements NewsHeaderServices {

	@Autowired
	private NewsHeaderRepository newsHeaderRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private NewsStatusRepository newsStatusRepository;

	@Override
	public NewsHeader createNewsHeader(NewsHeader newsHeader) {

		int topicId = newsHeader.getTopic() != null ? newsHeader.getTopic().getId() : 0;
		Topic topic = this.topicRepository.findById(topicId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.TOPIC_NOT_FOUND));
		String statusCode = newsHeader.getNewsStatus() != null ? newsHeader.getNewsStatus().getCode() : null;
		NewsStatus newsStatus = this.newsStatusRepository.findNewsStatusByCode(statusCode);
		if (newsStatus == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_STATUS_NOT_FOUND);
		}

		newsHeader.setTopic(topic);
		newsHeader.setNewsStatus(newsStatus);
		newsHeader.setCreatedDate(new Timestamp(new Date().getTime()));

		return this.newsHeaderRepository.save(newsHeader);
	}

	@Override
	public NewsHeader updateNewsHeader(int newsHeaderId, NewsHeader newsHeader) {

		NewsHeader newsHeaderFromDB = this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
		int topicId = newsHeader.getTopic() != null ? newsHeader.getTopic().getId() : 0;
		Topic topic = this.topicRepository.findById(topicId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.TOPIC_NOT_FOUND));
		String statusCode = newsHeader.getNewsStatus() != null ? newsHeader.getNewsStatus().getCode() : null;
		NewsStatus newsStatus = this.newsStatusRepository.findNewsStatusByCode(statusCode);
		if (newsStatus == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_STATUS_NOT_FOUND);
		}

		newsHeaderFromDB.setTitle(newsHeader.getTitle());
		newsHeaderFromDB.setImage(newsHeader.getImage());
		newsHeaderFromDB.setVideo(newsHeader.getVideo());
		newsHeaderFromDB.setSummary(newsHeader.getSummary());
		newsHeaderFromDB.setTopic(topic);
		newsHeaderFromDB.setAuthorId(newsHeader.getAuthorId());
		newsHeaderFromDB.setNewsStatus(newsStatus);
		newsHeaderFromDB.setNumberViewers(newsHeader.getNumberViewers());
		newsHeaderFromDB.setHighlightLevel(newsHeader.gethighlightLevel());
		newsHeaderFromDB.setType(newsHeader.getType());
		newsHeaderFromDB.setLastModifiedDate(new java.sql.Date(new Date().getTime()));

		return this.newsHeaderRepository.save(newsHeaderFromDB);
	}

	@Override
	public void deleteNewsHeader(int newsHeaderId) {
		NewsHeader newsHeader = this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
		this.newsHeaderRepository.deleteById(newsHeader.getId());
	}

	@Override
	public List<NewsHeader> getAllNewsHeader() {
		return this.newsHeaderRepository.findAll();
	}

	@Override
	public NewsHeader getNewsHeaderById(int newsHeaderId) {
		return this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
	}

}
