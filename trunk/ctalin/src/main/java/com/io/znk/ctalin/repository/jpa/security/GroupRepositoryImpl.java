package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.Group;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
class GroupRepositoryImpl implements GroupRepository {
	
	@PersistenceContext
	private EntityManager em;

	
	private boolean groupExists(Long id) {
		Group g = find(id);
		return g != null ? true : false; 
	}
	
	@Override
	public Group save(Group group) {
		if(group != null) {
			if(group.getId() == null || !groupExists(group.getId())) {
				try {
					em.persist(group);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				group = null;
			}
		}
		return group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> all() {
		String query = "select distinct g from Group g left join fetch g.authorities left join fetch g.members";
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	@Override
	public Group find(Long id) {
		Group group = null;
		group = em.find(Group.class, id);
		if(group != null) {
			group.getAuthorities().size();
			group.getMembers().size();
		}	
		return group;
	}

	@Override
	public Group update(Group group) {
		Group g = null;
		if (group != null) {
			g = find(group.getId());
			if(g != null) {
				em.merge(group);
			} else {
				group = null;
			}
		}
		return group;
	}

	@Override
	public Group delete(Long id) {
		Group g = null;
		if (id != null) {
			g = find(id);
			if(g != null) {
				em.remove(g);
			}
		}
		return g;
	}

}
