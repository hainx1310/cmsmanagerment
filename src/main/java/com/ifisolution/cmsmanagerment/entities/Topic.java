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

@Entity
@Table(name = "cms_topic")
public class Topic {

	@Id
	private int id;

	@Column(name="name")
	private String name;

	@Column
	private int parentRefId;

	@Column
	private Timestamp createdAt;

	// one to many "topic_tracking"
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cms_topic")
	private List<TopicTracking> listTopic = new ArrayList<>();

	// one to many "cms_news_header"
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cms_topic")
	private List<NewsHeader> listNewsHeader = new ArrayList<>();

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

	public List<NewsHeader> getListNewsHeader() {
		return listNewsHeader;
	}

	public void setListNewsHeader(List<NewsHeader> listNewsHeader) {
		this.listNewsHeader = listNewsHeader;
	}

}
