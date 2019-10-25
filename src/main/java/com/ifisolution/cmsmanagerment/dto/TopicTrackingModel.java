package com.ifisolution.cmsmanagerment.dto;

import java.sql.Timestamp;

public class TopicTrackingModel {
	private int id;

	private int topicId;

	private String topicName;

	private String subTopicName;

	private boolean status;

	private Timestamp createAt;

	private int doctorId;

	private int userId;

	private String typeMember;

	public TopicTrackingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
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
