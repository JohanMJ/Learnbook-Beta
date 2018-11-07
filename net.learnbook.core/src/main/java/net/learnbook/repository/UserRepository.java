package net.learnbook.repository;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.User;

@Repository
public class UserRepository extends AbstractRepository<User>{

	public UserRepository() {
		super(User.class);
	}	

	@SuppressWarnings("unchecked")
	public List<User> listAllByCompany(Integer iCodUser) {
		try {
			String selectQuery = "SELECT us FROM User us WHERE companyId = :iCodUser";
			Query query = this.entityManager.createQuery(selectQuery);
			query.setParameter("iCodUser", iCodUser);
				
			System.out.println(selectQuery);
			return (List<User>) query.getResultList();

		} catch (IllegalArgumentException error) {
			error.printStackTrace();

		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

}
