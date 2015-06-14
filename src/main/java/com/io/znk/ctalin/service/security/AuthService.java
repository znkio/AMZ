package com.io.znk.ctalin.service.security;

import com.io.znk.ctalin.model.jpa.security.model.Authority;
import com.io.znk.ctalin.model.jpa.security.model.Group;
import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import com.io.znk.ctalin.model.jpa.security.model.User;
import java.util.List;



public interface AuthService {
	
	User createUser(User user);
	
	User updateUser(User user);
	
	User changeUserPassword(User user);
	
	User deleteUser(String username);

	User getUser(String username);
	
	User getUserByGuid(String userGuid);
	
	List<User> getAllUsers(Integer page);
	
	Authority addAuthorityToUser(Authority authority);
	
	List<Authority> getUserAuthorities(String username);
	
	Authority getUserAuthority(String username, String authority);

	Authority removeAuthorityFromUser(String username, String authority);
	
	Group createGroup(Group group);
	
	GroupMember createGroupMember(GroupMember groupMember);
	
	List<Group> getAllGroups();
	
	Group getGroup(Long id);

	List<GroupMember> getAllGroupMembers();

	Group updateGroup(Group group);

	Group deleteGroup(Long id);

	GroupAuthority createGroupAuthority(GroupAuthority ga);

	List<GroupAuthority> getAllGroupAuthorities();

	List<GroupAuthority> getGroupAuthorities(Long groupId);

	GroupAuthority getGroupAuthority(Long groupId, String authority);

	GroupAuthority deleteGroupAuthority(Long groupId, String authority);

	List<GroupMember> getGroupMembersByUsername(String username);
	
	List<GroupMember> getGroupMembers(Long id);

	GroupMember getGroupMember(Long memberId);

	GroupMember deleteGroupMember(Long memberId);
	
	List<Group> listGroups(Integer page);
	
	List<User> getUsersWithAuthorityLike(String authority);
	
	List<User> getUsersWithAuthorityClient();
	
	List<User> getUsersWithAuthorityManager();
	
	List<User> getUsersWithAuthorityDeveloper();

}
