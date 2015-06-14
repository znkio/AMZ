package com.io.znk.ctalin.model.jpa.security.model;

import java.io.Serializable;

public class GroupAuthorityId implements Serializable {
	
	private static final long serialVersionUID = 9003504278842354656L;
	
	private String authority;
	
	private Long groupId;
	
	public GroupAuthorityId() {}
	
	public GroupAuthorityId(String authority, Long groupId) {
		super();
		this.authority = authority;
		this.groupId = groupId;
	}

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
	
}
