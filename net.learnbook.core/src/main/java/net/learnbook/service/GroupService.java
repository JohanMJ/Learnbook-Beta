package net.learnbook.service;

import java.util.List;

import net.learnbook.entity.Group;
import net.learnbook.repository.GroupRepository;

public interface GroupService {

	public void insert(Group group);
	
	public List<Group> listAll();
	
	public GroupRepository getRepository();
}
