package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.Authority;
import java.util.List;


public interface AuthorityRepository {
	
	Authority save(Authority authority);

	Authority find(String username, String authority);
	
	List<Authority> findByUsername(String username);

	Authority delete(Authority authority);
	
	List<Authority> findByAuthority(String authority);
	
	List<Authority> findByAuthorityLike(String authority);
	
}
