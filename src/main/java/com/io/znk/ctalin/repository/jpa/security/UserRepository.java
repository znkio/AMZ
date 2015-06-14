package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.User;
import java.util.List;


public interface UserRepository {
	
	User findByUsername(String username);
	
	User save(User user);

	List<User> list(Integer page);

	User update(User user);

	User delete(String username);

	User changePassword(User user);

	User findByGuid(String userGuid);

}
