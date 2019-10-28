package com.ifisolution.cmsmanagerment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cms_news_status")
public class NewsStatus {

	@Id
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@Column(name="desciption")
	private String desciption;

	// one to many "cms_news-status"
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsStatus")
	private List<NewsHeader> newsStatus = new ArrayList<>();

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public List<NewsHeader> getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(List<NewsHeader> newsStatus) {
		this.newsStatus = newsStatus;
	}
	
	
}
