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
import com.ifisolution.cmsmanagerment.dto.NewsHeaderDTO;
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
	public NewsHeader createNewsHeader(NewsHeaderDTO newsHeaderDTO) {

		Topic topic = this.topicRepository.findById(newsHeaderDTO.getTopicId())
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.TOPIC_NOT_FOUND));
		NewsStatus newsStatus = this.newsStatusRepository.findNewsStatusByCode(newsHeaderDTO.getStatus());
		if (newsStatus == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_STATUS_NOT_FOUND);
		}

		NewsHeader newsHeader = new NewsHeader();
		this.NewsHeaderDtoToNewsHeader(newsHeaderDTO, newsHeader);
		newsHeader.setTopic(topic);
		newsHeader.setNewsStatus(newsStatus);
		newsHeader.setCreatedDate(new Timestamp(new Date().getTime()));

		return this.newsHeaderRepository.save(newsHeader);
	}

	@Override
	public NewsHeader updateNewsHeader(int newsHeaderId, NewsHeaderDTO newsHeaderDTO) {

		NewsHeader newsHeader = this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
		int topicId = newsHeaderDTO.getTopicId();
		Topic topic = this.topicRepository.findById(topicId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.TOPIC_NOT_FOUND));
		String statusCode = newsHeaderDTO.getStatus();
		NewsStatus newsStatus = this.newsStatusRepository.findNewsStatusByCode(statusCode);
		if (newsStatus == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_STATUS_NOT_FOUND);
		}

		this.NewsHeaderDtoToNewsHeader(newsHeaderDTO, newsHeader);
		newsHeader.setTopic(topic);
		newsHeader.setNewsStatus(newsStatus);
		newsHeader.setLastModifiedDate(new java.sql.Date(new Date().getTime()));

		return this.newsHeaderRepository.save(newsHeader);
	}

	@Override
	public void deleteNewsHeader(int newsHeaderId) {
		this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
		this.newsHeaderRepository.deleteById(newsHeaderId);
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

	@Override
	public List<NewsHeader> findNewsHeadersByTopicId(int topicId) {
		this.topicRepository.findById(topicId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.TOPIC_NOT_FOUND));
		return this.newsHeaderRepository.findNewsHeadersByTopicId(topicId);
	}

	@Override
	public List<NewsHeader> findNewsHeadersByNewsStatusCode(String statusCode) {
		if (this.newsStatusRepository.findNewsStatusByCode(statusCode) == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_STATUS_NOT_FOUND);
		}
		return this.newsHeaderRepository.findNewsHeadersByNewsStatusCode(statusCode);
	}

	private void NewsHeaderDtoToNewsHeader(NewsHeaderDTO newsHeaderDTO, NewsHeader newsHeader) {
		newsHeader.setTitle(newsHeaderDTO.getTitle());
		newsHeader.setImage(newsHeaderDTO.getImage());
		newsHeader.setVideo(newsHeaderDTO.getVideo());
		newsHeader.setSummary(newsHeaderDTO.getSummary());
		newsHeader.setAuthorId(newsHeaderDTO.getAuthorId());
		newsHeader.setNumberViewers(newsHeaderDTO.getNumberViewers());
		newsHeader.setHighlightLevel(newsHeaderDTO.getHighlightLevel());
		newsHeader.setType(newsHeaderDTO.getType());
	}
}
