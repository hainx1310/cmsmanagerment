package com.ifisolution.cmsmanagerment.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifisolution.cmsmanagerment.common.CommonConstant;
import com.ifisolution.cmsmanagerment.entities.NewsHeader;
import com.ifisolution.cmsmanagerment.entities.NewsShare;
import com.ifisolution.cmsmanagerment.repository.NewsHeaderRepository;
import com.ifisolution.cmsmanagerment.repository.NewsShareRepository;
import com.ifisolution.cmsmanagerment.services.NewsShareServices;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Configurable
@Transactional
public class NewsShareServiceImpl implements NewsShareServices {

	@Autowired
	private NewsShareRepository newsShareRepository;

	@Autowired
	private NewsHeaderRepository newsHeaderRepository;

	@Override
	public List<NewsShare> findAllNewsShare() {
		List<NewsShare> lstNewsShare = newsShareRepository.findAll();
		return lstNewsShare;
	}

	@Override
	public NewsShare create(NewsShare newsShare) {
		int newsHeaderId = newsShare.getNewsHeader() != null ? newsShare.getNewsHeader().getId() : 0;
		NewsHeader newsHeader = this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));
		newsShare.setNewsHeader(newsHeader);
		newsShare.setCreateAt(new Timestamp(new Date().getTime()));

		return this.newsShareRepository.save(newsShare);
	}

	@Override
	public NewsShare findByNewsShareId(int id) {
		NewsShare newShareResult = newsShareRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_SHARE_NOT_FOUND));
		return newShareResult;
	}

	@Override
	public List<NewsShare> findByNewsHeaderId(int id) {
		if (newsShareRepository.findNewsSharesByNewsHeaderId(id) == null) {
			throw new EntityNotFoundException(CommonConstant.NEWS_SHARE_NOT_FOUND);
		}
		return newsShareRepository.findNewsSharesByNewsHeaderId(id);
	}

	@Override
	public void deleteById(int id) {
		newsShareRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_SHARE_NOT_FOUND));
		newsShareRepository.deleteById(id);
	}

	@Override
	public NewsShare update(int id, NewsShare newsShare) {

		NewsShare newsShareOpt = newsShareRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_SHARE_NOT_FOUND));
		int newsHeaderId = newsShare.getNewsHeader() != null ? newsShare.getNewsHeader().getId() : 0;
		NewsHeader newsHeader = this.newsHeaderRepository.findById(newsHeaderId)
				.orElseThrow(() -> new EntityNotFoundException(CommonConstant.NEWS_HEADER_NOT_FOUND));

		newsShareOpt.setFromDoctorId(newsShare.getFromDoctorId());
		newsShareOpt.setFromUserId(newsShare.getFromUserId());
		newsShareOpt.setToDoctorId(newsShare.getToDoctorId());
		newsShareOpt.setToUserId(newsShare.getToUserId());
		newsShareOpt.setComment(newsShare.getComment());
		newsShareOpt.setStatus(newsShare.getStatus());
		newsShareOpt.setCreateAt(newsShare.getCreateAt());
		newsShareOpt.setNewsHeader(newsHeader);

		return this.newsShareRepository.save(newsShareOpt);
	}
}