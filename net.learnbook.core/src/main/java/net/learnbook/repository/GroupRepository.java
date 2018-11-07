package net.learnbook.repository;

import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import net.learnbook.entity.Group;

@Repository
public class GroupRepository extends AbstractRepository<Group> {

	public GroupRepository() {
		super(Group.class);
	}

	@SuppressWarnings("unchecked")
	public List<Group> listAllByUser(Integer iCodUser) {
		try {
			String selectQuery = "SELECT pkg FROM Group pkg WHERE user.iCodUser = :iCodUser";
			Query query = this.entityManager.createQuery(selectQuery);
			query.setParameter("iCodUser", iCodUser);
				
			System.out.println(selectQuery);
			return (List<Group>) query.getResultList();

		} catch (IllegalArgumentException error) {
			error.printStackTrace();

		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}
	
}
