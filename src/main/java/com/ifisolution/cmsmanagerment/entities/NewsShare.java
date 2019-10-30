package com.ifisolution.cmsmanagerment.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cms_news_share")
public class NewsShare {

	@Id
	private int id;

	@Column(name = "from_doctor_id")
	private int fromDoctorId;

	@Column(name = "from_user_id")
	private int fromUserId;

	@Column(name = "to_doctor_id")
	private int toDoctorId;

	@Column(name = "to_user_id")
	private int toUserId;

	@Column(name = "comment")
	private String comment;

	@Column(name = "status")
	private Boolean status;

//	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Timestamp createAt;

	@ManyToOne
	@JoinColumn(name = "news_id", referencedColumnName = "id")
	private NewsHeader newsHeader;

	@Column(name = "to_type")
	private String toType;

	public NewsShare(){};
	public NewsShare(int fromDoctorId, int fromUserId, int toDoctorId, int toUserId, String comment, Boolean status, Timestamp createAt, NewsHeader newsHeader, String toType) {
		this.fromDoctorId = fromDoctorId;
		this.fromUserId = fromUserId;
		this.toDoctorId = toDoctorId;
		this.toUserId = toUserId;
		this.comment = comment;
		this.status = status;
		this.createAt = createAt;
		this.newsHeader = newsHeader;
		this.toType = toType;
	}

	public int getId() {
		return id;
	}

	public int getFromDoctorId() {
		return fromDoctorId;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public int getToDoctorId() {
		return toDoctorId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public String getComment() {
		return comment;
	}

	public Boolean getStatus() {
		return status;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public NewsHeader getNewsHeader() {
		return newsHeader;
	}

	public String getToType() {
		return toType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFromDoctorId(int fromDoctorId) {
		this.fromDoctorId = fromDoctorId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public void setToDoctorId(int toDoctorId) {
		this.toDoctorId = toDoctorId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public void setNewsHeader(NewsHeader newsHeader) {
		this.newsHeader = newsHeader;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}
}

