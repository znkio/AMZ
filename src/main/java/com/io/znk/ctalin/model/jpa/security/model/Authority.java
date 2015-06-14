package com.io.znk.ctalin.model.jpa.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
@IdClass(AuthorityId.class)
public class Authority {
	
	@Id
	private String username;
	
	@Id
	private String authority;
	
	public Authority() {}
	
	public Authority(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
