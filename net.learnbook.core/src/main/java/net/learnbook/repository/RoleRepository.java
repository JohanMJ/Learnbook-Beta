package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Role;

@Repository
public class RoleRepository extends AbstractRepository<Role> {

	public RoleRepository() {
		super(Role.class);
	}

}
