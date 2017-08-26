package net.learnbook.service;



import net.learnbook.entity.User;
import net.learnbook.repository.UserRepository;

public interface UserService {

	public void insert(User user);
	
	public UserRepository getRepository();
}
