package com.ifisolution.cmsmanagerment.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cms_topic")
public class Topic {

	@Id
	private int id;

	@Column(name="name")
	@NotEmpty(message = "name not be empty")
	private String name;

	@Column(name="parent_ref_id")
	@NotEmpty(message = "parent ref id not be empty")
	private int parentRefId;

	@Column(name="created_at")
	private Timestamp createdAt;

	// one to many "topic_tracking"
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	private List<TopicTracking> listTopic = new ArrayList<>();

	// one to many "cms_news_header"
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	private List<NewsHeader> newsHeader = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentRefId() {
		return parentRefId;
	}

	public void setParentRefId(int parentRefId) {
		this.parentRefId = parentRefId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public List<TopicTracking> getListTopic() {
		return listTopic;
	}

	public void setListTopic(List<TopicTracking> listTopic) {
		this.listTopic = listTopic;
	}

	public List<NewsHeader> getNewsHeader() {
		return newsHeader;
	}

	public void setNewsHeader(List<NewsHeader> newsheader) {
		this.newsHeader = newsheader;
	}

	

}
