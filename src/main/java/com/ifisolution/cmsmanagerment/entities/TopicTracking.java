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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cms_topic_tracking")
public class TopicTracking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "topic_id", referencedColumnName = "id")
	private Topic topic;
	@Column(name = "topic_name")
	private String topicName;
	@Column(name = "sub_topic_name")
	private String subTopicName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "created_at")
	private Timestamp createAt;
	@Column(name = "doctor_id")
	private int doctorId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "type_member")
	private String typeMember;

	public TopicTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
		result = prime * result + doctorId;
		result = prime * result + id;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((subTopicName == null) ? 0 : subTopicName.hashCode());
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
		result = prime * result + ((typeMember == null) ? 0 : typeMember.hashCode());
		result = prime * result + userId;
		return result;
	}

}