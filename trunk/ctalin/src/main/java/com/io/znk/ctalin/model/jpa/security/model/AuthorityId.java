package com.io.znk.ctalin.model.jpa.security.model;

import java.io.Serializable;


public class AuthorityId implements Serializable {
	
	private static final long serialVersionUID = 4559933023707479824L;
	
	private String username;
	private String authority;
	
	public AuthorityId() {}
	
	public AuthorityId(String username, String authority) {
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
