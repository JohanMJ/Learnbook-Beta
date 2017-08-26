package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.User;

@Repository
public class UserRepository extends AbstractRepository<User>{

	public UserRepository() {
		super(User.class);
	}
	
	

}
