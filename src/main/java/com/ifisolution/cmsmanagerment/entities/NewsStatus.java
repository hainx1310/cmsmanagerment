package com.ifisolution.cmsmanagerment.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cms_news_status")
public class NewsStatus implements Serializable {

	@Id
	private int id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String desciption;

	// one to many "cms_news-status"
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsStatus")
	private List<NewsHeader> listNewsHeader = new ArrayList<>();

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public List<NewsHeader> getListNewsHeader() {
		return listNewsHeader;
	}

	public void setListNewsHeader(List<NewsHeader> listNewsHeader) {
		this.listNewsHeader = listNewsHeader;
	}

}
