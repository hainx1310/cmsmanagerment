package com.ifisolution.cmsmanagerment.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Setter
@Getter
@NoArgsConstructor
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

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Timestamp createAt;

	@ManyToOne
	@JoinColumn(name = "news_id", referencedColumnName = "id")
	private NewsHeader newsHeader;

	@Column(name = "to_type")
	private String toType;
}
