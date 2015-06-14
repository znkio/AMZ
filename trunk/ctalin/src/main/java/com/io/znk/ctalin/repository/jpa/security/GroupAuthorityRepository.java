package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
import java.util.List;


public interface GroupAuthorityRepository {
	
	GroupAuthority save(GroupAuthority ga);

	List<GroupAuthority> all();

	GroupAuthority find(Long groupId, String authority);

	List<GroupAuthority> findByGroupId(Long groupId);

	GroupAuthority delete(Long groupId, String authority);

}
