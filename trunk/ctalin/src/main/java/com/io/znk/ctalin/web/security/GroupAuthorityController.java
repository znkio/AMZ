package com.io.znk.ctalin.web.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
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
 * Handles requests for the GroupAuthority.
 */
@Controller
@RequestMapping(value = "/secured/groups")
public class GroupAuthorityController {
	
	@Autowired private AuthService authService;

	
	@RequestMapping(value = "/{id}/authorities", method=RequestMethod.GET)
	@ResponseBody
	public List<GroupAuthority> getGroupAuthorities(@PathVariable Long id) {
		return authService.getGroupAuthorities(id);
	}
	
	@RequestMapping(value = "/{id}/authorities/{authority}", method=RequestMethod.GET)
	public ResponseEntity<GroupAuthority> getGroupAuthority(@PathVariable Long id, @PathVariable String authority) {
		GroupAuthority ga = authService.getGroupAuthority(id, authority);
		if(ga != null) {
			return new ResponseEntity<GroupAuthority>(ga, HttpStatus.OK);
		}
		return new ResponseEntity<GroupAuthority>(ga, HttpStatus.NOT_FOUND); 
	}
	
	@RequestMapping(value = "/{id}/authorities", method=RequestMethod.POST)
	public ResponseEntity<GroupAuthority> createGroupAuthority(@RequestBody GroupAuthority groupAuthority, @PathVariable Long id, UriComponentsBuilder builder) {
		groupAuthority.setGroupId(id);
		GroupAuthority ga = authService.createGroupAuthority(groupAuthority);
		if(ga != null) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(
	                builder.path("/secured/groups/{id}/authorities/{authority}")
	                        .buildAndExpand(id, ga.getAuthority()).toUri());
	        
			return new ResponseEntity<GroupAuthority>(ga, headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<GroupAuthority>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/{id}/authorities/{authority}", method=RequestMethod.DELETE)
	public ResponseEntity<GroupAuthority> deleteGroupAuthority(@PathVariable Long id, @PathVariable String authority) {
		GroupAuthority ga = authService.deleteGroupAuthority(id, authority);
		
		if(ga != null) {
			return new ResponseEntity<GroupAuthority>(ga, HttpStatus.OK);
		}
		return new ResponseEntity<GroupAuthority>(ga, HttpStatus.NOT_FOUND);
	}
	
}
