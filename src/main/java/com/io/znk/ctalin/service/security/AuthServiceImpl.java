package com.io.znk.ctalin.service.security;

import com.io.znk.ctalin.model.jpa.security.model.Authority;
import com.io.znk.ctalin.model.jpa.security.model.Group;
import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import com.io.znk.ctalin.model.jpa.security.model.User;
import com.io.znk.ctalin.repository.jpa.security.AuthorityRepository;
import com.io.znk.ctalin.repository.jpa.security.GroupAuthorityRepository;
import com.io.znk.ctalin.repository.jpa.security.GroupMemberRepository;
import com.io.znk.ctalin.repository.jpa.security.GroupRepository;
import com.io.znk.ctalin.repository.jpa.security.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service(value="authService")
class AuthServiceImpl implements AuthService {
	
	@Autowired private UserRepository userRepository;
	
	@Autowired private AuthorityRepository authorityRepository;
	
	@Autowired private GroupRepository groupRepository;
	
	@Autowired private GroupMemberRepository groupMemberRepository;
	
	@Autowired private GroupAuthorityRepository groupAuthorityRepository;
	

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User getUserByGuid(String userGuid) {
		return userRepository.findByGuid(userGuid);
	}

	@Override
	public Authority addAuthorityToUser(Authority authority) {
		return authorityRepository.save(authority);
	}

	@Override
	public List<Authority> getUserAuthorities(String username) {
		return authorityRepository.findByUsername(username);
	}
	
	@Override
	public Authority getUserAuthority(String username, String authority) {
		return authorityRepository.find(username, authority);
	}

	@Override
	public List<User> getAllUsers(Integer page) {
		return userRepository.list(page);
	}

	@Override
	public User updateUser(User user) {
		User oldUser = userRepository.findByUsername(user.getUsername());
		oldUser.setEnabled(user.isEnabled());
		return userRepository.update(oldUser);
	}
	
	@Override
	public User changeUserPassword(User user) {
		return userRepository.changePassword(user);
	}

	@Override
	public User deleteUser(String username) {
		List<Authority> authorities = getUserAuthorities(username);
		for(Authority a : authorities) {
			removeAuthorityFromUser(a.getUsername(), a.getAuthority());
		}
		List<GroupMember> groupMembers = getGroupMembersByUsername(username);
		for(GroupMember gm : groupMembers) {
			deleteGroupMember(gm.getId());
		}
		return userRepository.delete(username);
	}

	@Override
	public Authority removeAuthorityFromUser(String username, String authority) {
		Authority a = new Authority(username, authority);
		return authorityRepository.delete(a);
	}

	@Override
	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}

	@Override
	public GroupMember createGroupMember(GroupMember groupMember) {
		return groupMemberRepository.save(groupMember);
	}

	@Override
	public List<Group> getAllGroups() {
		return groupRepository.all();
	}

	@Override
	public List<GroupMember> getAllGroupMembers() {
		return groupMemberRepository.all();
	}

	@Override
	public Group getGroup(Long id) {
		return groupRepository.find(id);
	}

	@Override
	public Group updateGroup(Group group) {
		return groupRepository.update(group);
	}

	@Override
	public Group deleteGroup(Long id) {
		List<GroupAuthority> authorities = getGroupAuthorities(id);
		for(GroupAuthority ga : authorities) {
			deleteGroupAuthority(id, ga.getAuthority());
		}
		List<GroupMember> members = getGroupMembers(id);
		for(GroupMember gm : members) {
			deleteGroupMember(gm.getId());
		}
		return groupRepository.delete(id);
	}

	@Override
	public GroupAuthority createGroupAuthority(GroupAuthority ga) {
		return groupAuthorityRepository.save(ga);
	}

	@Override
	public List<GroupAuthority> getAllGroupAuthorities() {
		return groupAuthorityRepository.all();
	}

	@Override
	public List<GroupAuthority> getGroupAuthorities(Long groupId) {
		return groupAuthorityRepository.findByGroupId(groupId);
	}

	@Override
	public GroupAuthority getGroupAuthority(Long groupId, String authority) {
		return groupAuthorityRepository.find(groupId, authority);
	}

	@Override
	public GroupAuthority deleteGroupAuthority(Long groupId, String authority) {
		return groupAuthorityRepository.delete(groupId, authority);
	}

	@Override
	public List<GroupMember> getGroupMembers(Long groupId) {
		return groupMemberRepository.findByGroupId(groupId);
	}

	@Override
	public GroupMember getGroupMember(Long memberId) {
		return groupMemberRepository.find(memberId);
	}

	@Override
	public GroupMember deleteGroupMember(Long memberId) {
		return groupMemberRepository.delete(memberId);
	}

	@Override
	public List<Group> listGroups(Integer page) {
		return groupRepository.all();
	}

	@Override
	public List<GroupMember> getGroupMembersByUsername(String username) {
		return groupMemberRepository.findByUsername(username);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public AuthorityRepository getAuthorityRepository() {
		return authorityRepository;
	}

	public void setAuthorityRepository(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}

	public GroupRepository getGroupRepository() {
		return groupRepository;
	}

	public void setGroupRepository(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}

	public GroupMemberRepository getGroupMemberRepository() {
		return groupMemberRepository;
	}

	public void setGroupMemberRepository(GroupMemberRepository groupMemberRepository) {
		this.groupMemberRepository = groupMemberRepository;
	}

	public GroupAuthorityRepository getGroupAuthorityRepository() {
		return groupAuthorityRepository;
	}

	public void setGroupAuthorityRepository(
			GroupAuthorityRepository groupAuthorityRepository) {
		this.groupAuthorityRepository = groupAuthorityRepository;
	}

	@Override
	public List<User> getUsersWithAuthorityLike(String authority) {
		List<Authority> authorities = authorityRepository.findByAuthorityLike(authority);
		List<User> clients = new ArrayList<>();
		for(Authority a : authorities) {
			User u = userRepository.findByUsername(a.getUsername());
			clients.add(u);
		}
		return clients;
	}
	
	@Override
	public List<User> getUsersWithAuthorityClient() {
		return getUsersWithAuthorityLike(Constants.Roles.CLIENT.getValue());
	}
	
	@Override
	public List<User> getUsersWithAuthorityManager() {
		return getUsersWithAuthorityLike(Constants.Roles.MANAGER.getValue());
	}
	
	@Override
	public List<User> getUsersWithAuthorityDeveloper() {
		return getUsersWithAuthorityLike(Constants.Roles.DEVELOPER.getValue());
	}

}
