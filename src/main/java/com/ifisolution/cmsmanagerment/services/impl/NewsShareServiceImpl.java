package com.ifisolution.cmsmanagerment.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifisolution.cmsmanagerment.entities.NewsShare;
import com.ifisolution.cmsmanagerment.repository.NewsShareRepository;
import com.ifisolution.cmsmanagerment.services.NewsShareServices;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Configurable
@Transactional
public class NewsShareServiceImpl implements NewsShareServices{

	@Autowired
	private NewsShareRepository newsShareRepository;

	@Override
	public List<NewsShare> findAllNewsShare() {
		List<NewsShare> lstNewsShare = newsShareRepository.findAll();
		return lstNewsShare;
	}

	@Override
	public NewsShare create(NewsShare newsShare) {
		NewsShare newShareResult = newsShareRepository.save(newsShare);
		return newShareResult;
	}

	@Override
	public NewsShare findByNewsShareId(int id) {
		NewsShare newShareResult = newsShareRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not fount"));
		return newShareResult;
	}

	@Override
	public List<NewsShare> findByNewsHeaderId(int id) {
		if(newsShareRepository.findNewsSharesByNewsHeaderId(id).size() == 0) {
			throw new EntityNotFoundException("Not fount");
		}
		return newsShareRepository.findNewsSharesByNewsHeaderId(id);
	}

	@Override
	public void deleteById(int id) {
		newsShareRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not fount"));
		newsShareRepository.deleteById(id);
	}

	@Override
	public NewsShare update(int id, NewsShare newsShare) {
		NewsShare newsShareOpt = newsShareRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not fount"));
		newsShareOpt.setFromDoctorId(newsShare.getFromDoctorId());
		newsShareOpt.setFromUserId(newsShare.getFromUserId());
		newsShareOpt.setToDoctorId(newsShare.getToDoctorId());
		newsShareOpt.setToUserId(newsShare.getToUserId());
		newsShareOpt.setComment(newsShare.getComment());
		newsShareOpt.setStatus(newsShare.getStatus());
		newsShareOpt.setCreateAt(newsShare.getCreateAt());
		newsShareOpt.setNewsHeader(newsShare.getNewsHeader());
		NewsShare newsShareResult = newsShareRepository.save(newsShareOpt);
		return newsShareResult;
	}

}