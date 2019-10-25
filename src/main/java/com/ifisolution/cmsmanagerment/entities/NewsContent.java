package com.ifisolution.cmsmanagerment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cms_news_content")
public class NewsContent {
	@Id
	private int id;
	@Column
	private String content;
	@Column
	private int newId;
	// many to one
	@ManyToOne()
	@JoinColumn(name = "newId", referencedColumnName = "id", insertable = false, updatable = false)
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

	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}
}
