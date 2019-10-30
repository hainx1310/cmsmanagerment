package com.ifisolution.cmsmanagerment.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cms_news_header")
public class NewsHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "image")
	private String image;

	@Column(name = "video")
	private String video;

	@Column(name = "summary")
	private String summary;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "author_id")
	private int authorId;

	@Column(name = "number_viewers")
	private int numberViewers;

	@Column(name = "highlight_level")
	private String highlightLevel;

	@Column(name = "type")
	private String type;

	@Column(name = "last_modified_date")
	private Date lastModifiedDate;

	@ManyToOne
	@JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
//	@JsonIgnore
	private Topic topic;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsHeader", cascade = { CascadeType.REMOVE })
	private Set<NewsRating> listNewsRating = new HashSet<NewsRating>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsHeader", cascade = { CascadeType.REMOVE })
	private Set<NewsShare> listNewsShare = new HashSet<NewsShare>();

	@ManyToOne
	@JoinColumn(name = "status", referencedColumnName = "code", nullable = false)
//	@JsonIgnore
	private NewsStatus newsStatus;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsHeader", cascade = { CascadeType.REMOVE })
	private Set<NewsContent> listNewsContent = new HashSet<NewsContent>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsHeader", cascade = { CascadeType.REMOVE })
	private Set<NewsComment> listNewsComment = new HashSet<NewsComment>();

	public NewsHeader() {

	}

	public NewsHeader(int id, String title, String image, String video, String summary, Timestamp createdDate,
			int authorId, int numberViewers, String highlightLevel, String type, Date lastModifiedDate, Topic topic,
			Set<NewsRating> listNewsRating, Set<NewsShare> listNewsShare, NewsStatus newsStatus,
			Set<NewsContent> listNewsContent, Set<NewsComment> listNewsComment) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.video = video;
		this.summary = summary;
		this.createdDate = createdDate;
		this.authorId = authorId;
		this.numberViewers = numberViewers;
		this.highlightLevel = highlightLevel;
		this.type = type;
		this.lastModifiedDate = lastModifiedDate;
		this.topic = topic;
		this.listNewsRating = listNewsRating;
		this.listNewsShare = listNewsShare;
		this.newsStatus = newsStatus;
		this.listNewsContent = listNewsContent;
		this.listNewsComment = listNewsComment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getNumberViewers() {
		return numberViewers;
	}

	public void setNumberViewers(int numberViewers) {
		this.numberViewers = numberViewers;
	}

	public String gethighlightLevel() {
		return highlightLevel;
	}

	public void setHighlightLevel(String highlightLevel) {
		this.highlightLevel = highlightLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Set<NewsRating> getListNewsRating() {
		return listNewsRating;
	}

	public void setListNewsRating(Set<NewsRating> listNewsRating) {
		this.listNewsRating = listNewsRating;
	}

	public Set<NewsShare> getListNewsShare() {
		return listNewsShare;
	}

	public void setListNewsShare(Set<NewsShare> listNewsShare) {
		this.listNewsShare = listNewsShare;
	}

	public NewsStatus getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(NewsStatus newsStatus) {
		this.newsStatus = newsStatus;
	}

	public Set<NewsContent> getListNewsContent() {
		return listNewsContent;
	}

	public void setListNewsContent(Set<NewsContent> listNewsContent) {
		this.listNewsContent = listNewsContent;
	}

	public Set<NewsComment> getListNewsComment() {
		return listNewsComment;
	}

	public void setListNewsComment(Set<NewsComment> listNewsComment) {
		this.listNewsComment = listNewsComment;
	}

}
