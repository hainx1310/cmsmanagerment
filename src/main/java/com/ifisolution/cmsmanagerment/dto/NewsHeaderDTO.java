package com.ifisolution.cmsmanagerment.dto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class NewsHeaderDTO {

	private int id;

	@NotEmpty(message = "tittle may not be empty")
	@Length(max = 255, message = "title max 255 key word")
	private String title;

	@NotEmpty(message = "summary may not be empty")
	@Length(max = 255, message = "summary max 255 key word")
	private String image;

	@NotEmpty(message = "summary may not be empty")
	@Length(max = 255, message = "summary max 255 key word")
	private String video;

	@NotEmpty(message = "summary may not be empty")
	@Length(max = 255, message = "summary max 255 key word")
	private String summary;

	private Timestamp createdDate;

	@NotNull(message = "topicId may not be empty")
	private Integer topicId;

	@NotNull(message = "authorId may not be empty")
	private Integer authorId;

	@NotEmpty(message = "status may not be empty")
	@Length(max = 255, message = "status max 255 key word")
	private String status;

	private int numberViewers;
	private String highlightLevel;
	private String type;
	private Date lastModifiedDate;

	public NewsHeaderDTO() {

	}

	public NewsHeaderDTO(int id, String title, String image, String video, String summary, Timestamp createdDate,
			int topicId, int authorId, String status, int numberViewers, String highlightLevel, String type,
			Date lastModifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.video = video;
		this.summary = summary;
		this.createdDate = createdDate;
		this.topicId = topicId;
		this.authorId = authorId;
		this.status = status;
		this.numberViewers = numberViewers;
		this.highlightLevel = highlightLevel;
		this.type = type;
		this.lastModifiedDate = lastModifiedDate;
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

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumberViewers() {
		return numberViewers;
	}

	public void setNumberViewers(int numberViewers) {
		this.numberViewers = numberViewers;
	}

	public String getHighlightLevel() {
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

}
