package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupAuthority;
import com.io.znk.ctalin.model.jpa.security.model.GroupAuthorityId;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;



@Repository
class GroupAuthorityRepositoryImpl implements GroupAuthorityRepository {
	
	@PersistenceContext
	private EntityManager em;

	private boolean groupAuthorityExists(Long groupId, String authority) {
		GroupAuthority ga = find(groupId, authority);
		return ga != null ? true : false; 
	}
	
	@Override
	public GroupAuthority find(Long groupId, String authority) {
		GroupAuthority ga = null;
		if(groupId != null && authority != null) {
			ga = em.find(GroupAuthority.class, new GroupAuthorityId(authority, groupId));
		}
		
		return ga;
	}
	
	@Override
	public GroupAuthority save(GroupAuthority ga) {
		if(ga != null) {
			if(!groupAuthorityExists(ga.getGroupId(), ga.getAuthority())) {
				em.persist(ga);
			} else {
				ga = null;
			}
		}
		return ga;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupAuthority> all() {
		return em.createQuery("from GroupAuthority").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupAuthority> findByGroupId(Long groupId) {
		return em.createQuery("from GroupAuthority where groupId=:groupId").setParameter("groupId", groupId).getResultList();
	}

	@Override
	public GroupAuthority delete(Long groupId, String authority) {
		GroupAuthority ga = null;
		if (groupId != null) {
			ga = find(groupId, authority);
			if(ga != null) {
				em.remove(ga);
			}
		}
		return ga;
	}

}
