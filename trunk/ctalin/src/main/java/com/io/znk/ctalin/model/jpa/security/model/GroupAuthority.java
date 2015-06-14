package com.io.znk.ctalin.model.jpa.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="group_authorities")
@IdClass(GroupAuthorityId.class)
public class GroupAuthority {
	
	@Id
	private String authority;

	@Id
	@Column(name="group_id")
	private Long groupId;
	
	/*
	 * @JsonBackReference is used to specify that GroupAuthority is the child of the relationship between 
	 * Group and GroupAuthority. Without @JsonBackReference we would have an infinite loop during the 
	 * serialization of JSON. We could also use @JsonIgnore just on GroupAuthority to tell jackson to 
	 * completely ignore the field group during serialization.
	 */
	@JsonBackReference("group-authority")
	@ManyToOne
	@JoinColumn(name="group_id", insertable = false, updatable = false)
	private Group group;
	
	public GroupAuthority() {}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
