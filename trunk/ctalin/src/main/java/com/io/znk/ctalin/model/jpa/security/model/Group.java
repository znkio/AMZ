package com.io.znk.ctalin.model.jpa.security.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/*
 * The annotation NON_EMPTY is used in combination with the jackson-datatype-hibernate4 module (in pom.xml)
 * What it does is telling jackson to not display lazy loaded collections. Without it on the final json we 
 * would have "authorities: null" if they were lazy loaded.
 */
@JsonInclude(Include.NON_EMPTY)
@Entity
@Table(name="groups")
public class Group {
	
	/* Using AUTO to keep it database agnostic. Since we are currently using Postgres, in order for
	 * AUTO to work we need a hibernate_sequence created on the database. Otherwise we would need
	 * to create our own sequence. 
	 * 
	 * Example: @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_seq")
	 * 			@SequenceGenerator(name = "groups_seq", sequenceName = "groups_seq")
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="group_name")
	private String groupName;
	
	/*
	 * @JsonManagedReference is used to specify that Group is the owner of the relationship between 
	 * Group and GroupAuthority. On the GroupAuthority we use @JsonBackReference to indicate the opposite
	 * Without @JsonBackReference we would have an infinite loop during the serialization of JSON
	 */
	@JsonManagedReference("group-authority")
	@OneToMany(mappedBy = "group")
	private Set<GroupAuthority> authorities;
	
	@JsonManagedReference("group-member")
	@OneToMany(mappedBy = "group")
	private Set<GroupMember> members;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<GroupAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<GroupAuthority> authorities) {
		this.authorities = authorities;
	}

	public Set<GroupMember> getMembers() {
		return members;
	}

	public void setMembers(Set<GroupMember> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + "]";
	}
	
}
