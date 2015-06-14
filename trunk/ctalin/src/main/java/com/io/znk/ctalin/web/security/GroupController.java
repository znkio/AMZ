package com.io.znk.ctalin.web.security;

import com.io.znk.ctalin.model.jpa.security.model.Group;
import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import com.io.znk.ctalin.service.security.AuthService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Handles requests for the User.
 */
@Controller
@RequestMapping(value = "/secured/groups")
public class GroupController {
	
	@Autowired private AuthService authService;

	// Views
	
	@RequestMapping(value = "/new")
	public String newForm() {
		
		return "groups/new";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<Group> groups = authService.listGroups(null);
		model.addAttribute("groups", groups);
		return "groups/list";
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		Group g = authService.getGroup(id);
		model.addAttribute("g", g);
		
		List<GroupAuthority> authorities = authService.getGroupAuthorities(id);
		model.addAttribute("authorities", authorities);
		
		List<GroupMember> members = authService.getGroupMembers(id);
		model.addAttribute("members", members);
		
		return "groups/edit";
	}
	
	// API Groups
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Group> getAllGroups() {
		return authService.getAllGroups();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Group> getGroup(@PathVariable Long id) {
		Group g = authService.getGroup(id);
		
		if(g == null) {
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Group>(g, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Group> createGroup(@RequestBody Group group, UriComponentsBuilder builder) {
		Group g = authService.createGroup(group);
		
		if(g != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(
					builder.path("/secured/groups/{id}")
							.buildAndExpand(g.getId()).toUri());
			return new ResponseEntity<Group>(g, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Group>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.POST)
	public ResponseEntity<Group> updateGroup( @RequestBody Group group, @PathVariable Long id, UriComponentsBuilder builder) {
		Group g = authService.updateGroup(group);
		
		if(g != null) {
			return new ResponseEntity<Group>(g, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
		Group g = authService.deleteGroup(id);
		
		if(g != null) {
			return new ResponseEntity<Group>(g, HttpStatus.OK);
		}
		
		return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
	}
	
	// test
	@RequestMapping(value = "/{id}/members/create")
	@ResponseBody
	public GroupMember saveGroupMember(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="id", required=true) Long id,
			@RequestParam(value="group_id", required=true) Long groupId) {
		
		
		Group g = new Group();
		g.setId(groupId);
		List<Group> groups = new ArrayList<>();
		groups.add(g);
		GroupMember gm = new GroupMember();
		gm.setUsername(username);
		gm.setId(id);
		gm.setGroup(g);
		return authService.createGroupMember(gm);
	}
	
	
	
}
