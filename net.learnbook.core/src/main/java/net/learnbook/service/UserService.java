package net.learnbook.service;



import java.util.List;

import net.learnbook.entity.User;
import net.learnbook.repository.UserRepository;

public interface UserService {

	public void insert(User user);
	
	public void update(User user);
	
	public List<User> listAll();
	
	public User findById(Integer iCodUser);
	
	public User findByLogin(String sLogin);
	
	public UserRepository getRepository();
	
	public List<User> listAllByCompany(Integer iCodUser);
	
	public List<User> listAllCompanies();
	
	public List<User> listAllByGroup(Integer iCodGru);
	
}
