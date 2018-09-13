package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Group;

@Repository
public class GroupRepository extends AbstractRepository<Group> {

	public GroupRepository() {
		super(Group.class);
	}

}
