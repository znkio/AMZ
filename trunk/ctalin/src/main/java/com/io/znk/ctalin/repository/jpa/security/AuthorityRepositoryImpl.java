package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.Authority;
import com.io.znk.ctalin.model.jpa.security.model.AuthorityId;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;



@Repository
class AuthorityRepositoryImpl implements AuthorityRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Authority save(Authority authority) {
		if (authority != null && authority.getUsername() != null) {
			if(!authorityExists(authority)) {
				em.persist(authority);
			} else {
				authority = null;
			}
		}
		
		return authority;
	}
	
	private boolean authorityExists(Authority a) {
		Authority authorityInDB = find(a.getUsername(), a.getAuthority());
		return authorityInDB != null ? true : false; 
	}
	
	@Override
	public Authority find(String username, String authority) {
		return em.find(Authority.class, new AuthorityId(username, authority));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> findByUsername(String username) {
		return em.createQuery("from Authority where username=:username").setParameter("username",  username).getResultList();
	}

	@Override
	public Authority delete(Authority authority) {
		Authority a = null;
		if (authority != null) {
			a = find(authority.getUsername(), authority.getAuthority());
			if(a != null) {
				em.remove(em.contains(a) ? a : em.merge(a));
			}
		}
		return a;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> findByAuthority(String authority) {
		return em.createQuery("from Authority where authority=:authority").setParameter("authority",  authority).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> findByAuthorityLike(String authority) {
		return em.createQuery("from Authority where authority like :authority").setParameter("authority",  "%" + authority + "%").getResultList();
	}

}
