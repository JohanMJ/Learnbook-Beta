package net.learnbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Role;
import net.learnbook.repository.RoleRepository;


@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findRole(Integer iCodRol) {
		return this.roleRepository.findById(iCodRol);
	}





	@Override
	public RoleRepository getRepository() {
		return roleRepository;
	}



}
