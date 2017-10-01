package net.learnbook.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.User;

@Repository
public class UserRepository extends AbstractRepository<User>{

	public UserRepository() {
		super(User.class);
	}
	
	
	
	public User loadUserByUsername(String sLogUser) {
		User user;
		String sql;
		
		sql = "SELECT u FROM user u WHERE u.username = :username";
		
		try {
			user = entityManager.createQuery(sql, User.class)
									.setParameter("username", sLogUser)
									.getSingleResult();
			
		} catch (NoResultException error) {
			return null;
		}
		System.out.println("aqui" + user);
		return user;
	}
	
	

}
