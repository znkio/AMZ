package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.User;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;



@Repository
class UserRepositoryImpl implements UserRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	private static final String SALT = "QxLUF1bgIAdeQX";
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired private Md5PasswordEncoder passwordEncoder;
	
	
	@Override
	@Cacheable(key="#userGuid", value="clients")
	public User findByGuid(String userGuid) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> fromUser = query.from(User.class);
		Predicate userGuidEq = cb.equal(fromUser.<String>get("guid"), userGuid);
		query.select(fromUser).where(userGuidEq);
		User u = null;
		try {
			u = em.createQuery(query).getSingleResult();
		} catch(NoResultException nre) {
			logger.info(String.format("User with guid: %s not found", userGuid));
		}
		
		return u;
	}
	

	@Override
	public User findByUsername(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> fromUser = query.from(User.class);
		Predicate usernameEq = cb.equal(fromUser.<String>get("username"), username);
		query.select(fromUser).where(usernameEq);
		User u = null;
		try {
			u = em.createQuery(query).getSingleResult();
		} catch(NoResultException nre) { 
			logger.info(String.format("User with username: %s not found", username));
		}
		
		return u;
		
	}

	@Override
	public User save(User user) {
		if (user != null) {
			if (!usernameExists(user.getUsername())) {
				// Generating guid for user.
				user.setGuid(UUID.randomUUID().toString());
				user.setPassword(passwordEncoder.encodePassword(user.getPassword(), SALT));
				em.persist(user);
			} else {
				user = null;
			}
		}
		return user;
	}
	
	/*@SuppressWarnings("unused")
	private String encodePassword(String plainPassword) {
		String digest = passwordEncoder.encodePassword(plainPassword, "ilyda");
		byte[] hash = base64Encoder.encode(digest.getBytes());
		return new String(hash);
	}*/
	
	private boolean usernameExists(String username) {
		User u = findByUsername(username);
		return u != null ? true : false; 
	}

	@Override
	public List<User> list(Integer page) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> fromUser = query.from(User.class);
		query.select(fromUser);
		return em.createQuery(query).getResultList();
	}

	@Override
	public User update(User user) {
		if (user != null) {
			// If user happens to have no guid we assign one.
			if(user.getGuid() == null || user.getGuid().isEmpty()) {
				user.setGuid(UUID.randomUUID().toString());
			}
			em.merge(user);
		}
		return user;
	}
	
	@Override
	public User changePassword(User user) {
		if (user != null) {
			if(user.getGuid() == null || user.getGuid().isEmpty()) {
				user.setGuid(UUID.randomUUID().toString());
			}
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), SALT));
			em.merge(user);
		}
		return user;
	}
	
	@Override
	public User delete(String username) {
		User u = null;
		if (username != null) {
			u = findByUsername(username);
			if(u != null) {
				em.remove(u);
			}
		}
		return u;
	}

}
