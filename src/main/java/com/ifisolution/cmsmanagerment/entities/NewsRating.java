package com.ifisolution.cmsmanagerment.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cms_news_rating")
public class NewsRating implements Serializable {

	@Id
	@Column(name = "id")
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
	@Column(name = "status")
	private int status;
	@Column(name = "created_at")
	private Timestamp createdAt;
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "news_id", nullable = false)
	private NewsHeader newsHeader;

	public NewsRating() {
	}

	public NewsRating(int id, int doctorId, int userId, String typeMember, String name, String email, int status,
			Timestamp createAt, NewsHeader newsId) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.userId = userId;
		this.typeMember = typeMember;
		this.name = name;
		this.email = email;
		this.status = status;
		this.createdAt = createAt;
		this.newsHeader = newsId;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreateAt() {
		return createdAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createdAt = createAt;
	}

	public NewsHeader getNewsId() {
		return this.newsHeader;
	}

	public void setNewsId(NewsHeader newsId) {
		this.newsHeader = newsId;
	}
}
