package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.GroupMember;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


@Repository
class GroupMemberRepositoryImpl implements GroupMemberRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	private boolean groupMemberExists(Long memberId) {
		GroupMember gm = find(memberId);
		return gm != null ? true : false; 
	}
	
	@Override
	public GroupMember find(Long memberId) {
		GroupMember gm = null;
		if(memberId != null) {
			gm = em.find(GroupMember.class, memberId);
		}
		return gm;
	}

	@Override
	public GroupMember save(GroupMember groupMember) {
		if(groupMember != null) {
			if(!groupMemberExists(groupMember.getId())) {
				em.persist(groupMember);
			} else {
				groupMember = null;
			}	
		}
		return groupMember;
	}

	@Override
	public List<GroupMember> all() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GroupMember> query = cb.createQuery(GroupMember.class);
		Root<GroupMember> fromGroupMember = query.from(GroupMember.class);
		query.select(fromGroupMember);
		return em.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupMember> findByGroupId(Long groupId) {
		return em.createQuery("from GroupMember where groupId=:groupId").setParameter("groupId", groupId).getResultList();
	}

	@Override
	public GroupMember delete(Long memberId) {
		GroupMember gm = null;
		if (memberId != null) {
			gm = find(memberId);
			if(gm != null) {
				em.remove(gm);
			}
		}
		return gm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupMember> findByUsername(String username) {
		return em.createQuery("from GroupMember where username=:username").setParameter("username", username).getResultList();
	}

}
