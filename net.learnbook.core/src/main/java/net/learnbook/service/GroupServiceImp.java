package net.learnbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Group;
import net.learnbook.repository.GroupRepository;

@Service
@Primary
public class GroupServiceImp implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public void insert(Group group) {
		groupRepository.save(group);
	}
	
	@Override
	public List<Group> listAll() {

		return groupRepository.list("Group");
	}

	@Override
	public GroupRepository getRepository() {
		return groupRepository;
	}
	
	

}
