package com.io.znk.ctalin.web.security;

import com.io.znk.ctalin.model.jpa.security.model.Authority;
import com.io.znk.ctalin.model.jpa.security.model.User;
import com.io.znk.ctalin.service.security.AuthService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;



/**
 * Handles requests for the User.
 */
@Controller
@RequestMapping("/secured/users")
public class UserController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private AuthService authService;

	// Views
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newForm() {
		return "/users/new";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = authService.getAllUsers(null);
		model.addAttribute("users", users);
		return "users/list";
	}
	
	@RequestMapping(value = "/{username}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable String username, Model model) {
		User u = authService.getUser(username);
		model.addAttribute("u", u);
		
		List<Authority> authorities = authService.getUserAuthorities(username);
		model.addAttribute("authorities", authorities);
		
		return "users/edit";
	}
	
	// API Users
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> listJson() {
		return authService.getAllUsers(null);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String username) {
		User u = authService.getUser(username);
		if (u == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		User u = authService.createUser(user);
		
		if(u != null) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(
	                builder.path("/secured/users/{username}")
	                        .buildAndExpand(u.getUsername()).toUri());
	        
			return new ResponseEntity<User>(u, headers, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/{username}/delete", method = RequestMethod.POST)
	public ResponseEntity<User> deleteUser(@PathVariable String username) {
		User u = authService.deleteUser(username);
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {
		User u = null;
		if( user.getPassword() != null && !user.getPassword().isEmpty() ) {
			u = authService.changeUserPassword(user);
		} else {
			u = authService.updateUser(user);
		}
		
		if (u != null) {
			return new ResponseEntity<User>(u, HttpStatus.CREATED);	
		}
		
		return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
	}
	
	// API Authorities
	
	@RequestMapping(value = "/{username}/authorities", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Authority> getUserAuthorties(@PathVariable String username) {
		return authService.getUserAuthorities(username);
	}
	
	@RequestMapping(value = "/{username}/authorities/{authority}", method = RequestMethod.GET)
	public ResponseEntity<Authority> getUserAuthority(@PathVariable String username, @PathVariable String authority) {
		Authority a = authService.getUserAuthority(username, authority);
		
		if (a == null) {
            return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
        }
		
		return new ResponseEntity<Authority>(a, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{username}/authorities", method = RequestMethod.POST)
	public ResponseEntity<Authority> createAuthority(
			@PathVariable String username, 
			@RequestBody Authority authority, UriComponentsBuilder builder) {
		authority.setUsername(username);
		Authority a = authService.addAuthorityToUser(authority);
		
		if(a != null) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(
	                builder.path("/secured/users/{username}/authorities/{authority}")
	                        .buildAndExpand(username, a.getAuthority()).toUri());
			
			return new ResponseEntity<Authority>(a, headers, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Authority>(a, HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/{username}/authorities/{authority}/delete", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public ResponseEntity<Authority> deleteAuthority(@PathVariable String username, @PathVariable String authority) {
		Authority a = authService.removeAuthorityFromUser(username, authority);
		
		if(a != null) {
			return new ResponseEntity<Authority>(a, HttpStatus.OK);
		}
		
		return new ResponseEntity<Authority>(a, HttpStatus.NOT_FOUND);
	}
	
}
