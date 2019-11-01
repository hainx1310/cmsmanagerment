package com.ifisolution.cmsmanagerment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cms_news_content")
public class NewsContent {
	@Id
	private int id;
	
	@Column(name="content")
	@NotEmpty(message = "content not be empty")
	private String content;

	// many to one
	@ManyToOne()
	@JoinColumn(name = "news_id", referencedColumnName = "id")
	private NewsHeader newsHeader;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsHeader getNewsHeader() {
		return newsHeader;
	}

	public void setNewsHeader(NewsHeader newsHeader) {
		this.newsHeader = newsHeader;
	}
	
	
}
