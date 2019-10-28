package com.ifisolution.cmsmanagerment.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="cms_news_comment")
public class NewsComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "type_member")
	private String typeMember;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "comment")
	private String comment;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "status_publish")
	private boolean statusPublish;

	@ManyToOne
	@JoinColumn(name = "news_id", referencedColumnName = "id")
	private NewsHeader newsHeader;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTypeMember() {
		return typeMember;
	}

	public void setTypeMember(String typeMember) {
		this.typeMember = typeMember;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isStatusPublish() {
		return statusPublish;
	}

	public void setStatusPublish(boolean statusPublish) {
		this.statusPublish = statusPublish;
	}

	public NewsHeader getNewsHeader() {
		return newsHeader;
	}

	public void setNewsHeader(NewsHeader newsHeader) {
		this.newsHeader = newsHeader;
	}
}
