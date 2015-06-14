package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import java.util.List;


public interface GroupMemberRepository {
	
	GroupMember save(GroupMember groupMember);

	List<GroupMember> all();

	List<GroupMember> findByGroupId(Long groupId);

	GroupMember find(Long memberId);

	GroupMember delete(Long memberId);

	List<GroupMember> findByUsername(String username);
	
}
