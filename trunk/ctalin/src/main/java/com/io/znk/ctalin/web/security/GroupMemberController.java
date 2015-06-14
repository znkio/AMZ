package com.io.znk.ctalin.web.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import com.io.znk.ctalin.service.security.AuthService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;



/**
 * Handles requests for the GroupMember.
 */
@Controller
@RequestMapping(value = "/secured/groups")
public class GroupMemberController {
	
	@Autowired private AuthService authService;

	
	@RequestMapping(value = "/{groupId}/members", method=RequestMethod.GET)
	@ResponseBody
	public List<GroupMember> getGroupMembers(@PathVariable Long groupId) {
		return authService.getGroupMembers(groupId);
	}
	
	@RequestMapping(value = "/{groupId}/members/{memberId}", method=RequestMethod.GET)
	public ResponseEntity<GroupMember> getGroupMember(@PathVariable Long groupId, @PathVariable Long memberId) {
		GroupMember gm = authService.getGroupMember(memberId);
		
		if(gm != null) {
			return new ResponseEntity<GroupMember>(gm, HttpStatus.OK); 
		}
		
		return new ResponseEntity<GroupMember>(gm, HttpStatus.NOT_FOUND); 
	}
	
	@RequestMapping(value = "/{groupId}/members", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GroupMember> createGroupMember(@PathVariable Long groupId, @RequestBody GroupMember groupMember, UriComponentsBuilder builder) {
		groupMember.setGroupId(groupId);
		GroupMember gm = authService.createGroupMember(groupMember);
		if(gm != null) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(
	                builder.path("/secured/groups/{groupId}/members/{memberId}")
	                        .buildAndExpand(groupId, gm.getId()).toUri());
	        
			return new ResponseEntity<GroupMember>(gm, headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<GroupMember>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/{groupId}/members/{memberId}", method=RequestMethod.DELETE)
	public ResponseEntity<GroupMember> deleteGroupAuthority(@PathVariable Long groupId, @PathVariable Long memberId) {
		GroupMember gm = authService.deleteGroupMember(memberId);
		
		if(gm != null) {
			return new ResponseEntity<GroupMember>(gm, HttpStatus.OK);
		}
		return new ResponseEntity<GroupMember>(gm, HttpStatus.NOT_FOUND);
	}
	
}
