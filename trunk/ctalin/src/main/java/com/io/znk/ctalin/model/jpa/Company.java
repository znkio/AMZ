package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import javax.persistence.Lob;

@Table(name = "company")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company implements Serializable {

	private static final long serialVersionUID = 1085548653431275261L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long companyId;

	@NotNull
	@Column(unique = true)
	private String title;

	// @Lob
	@Column
	private String comments;

	public Company() {
	}

	public Company(String title, String comments) {
		this.title = title;
		this.comments = comments;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
