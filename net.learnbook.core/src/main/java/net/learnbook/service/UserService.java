package net.learnbook.service;



import java.util.List;

import net.learnbook.entity.User;
import net.learnbook.repository.UserRepository;

public interface UserService {

	public void insert(User user);
	
	public List<User> listAll();
	
	public User findById(Integer iCodUser);
	
	public User findByLogin(String sLogin);
	
	public UserRepository getRepository();
}
