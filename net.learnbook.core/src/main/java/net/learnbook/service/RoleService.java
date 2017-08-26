package net.learnbook.service;



import net.learnbook.entity.Role;
import net.learnbook.repository.RoleRepository;

public interface RoleService {

	public Role findRole(Integer iCodRol);
	
	public RoleRepository getRepository();
}
