package com.io.znk.ctalin.repository.jpa.security;

import com.io.znk.ctalin.model.jpa.security.model.Group;
import java.util.List;


public interface GroupRepository {
	
	Group save(Group group);
	
	List<Group> all();
	
	Group find(Long id);

	Group update(Group group);

	Group delete(Long id);

}
