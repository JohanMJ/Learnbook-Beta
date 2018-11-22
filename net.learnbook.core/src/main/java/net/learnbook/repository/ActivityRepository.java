package net.learnbook.repository;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Activity;

@Repository
public class ActivityRepository extends AbstractRepository<Activity>{

	public ActivityRepository() {
		super(Activity.class);
	}

	@SuppressWarnings("unchecked")
	public List<Activity> listActivitiesFromCourse(String className, Integer iCodCou) {
		try {
			String selectQuery = "SELECT at FROM " + className + "  at  WHERE at.course.iCodCou = :iCodCou";
			Query query = this.entityManager.createQuery(selectQuery);
			query.setParameter("iCodCou", iCodCou);
				
			System.out.println(selectQuery);
			return (List<Activity>) query.getResultList();

		} catch (IllegalArgumentException error) {
			error.printStackTrace();

		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Activity> getActivitiesFromReview(String className) {
		try {
			String selectQuery = "SELECT at FROM " + className + "  at  WHERE corrigido = true";
			Query query = this.entityManager.createQuery(selectQuery);
				
			System.out.println(selectQuery);
			return (List<Activity>) query.getResultList();

		} catch (IllegalArgumentException error) {
			error.printStackTrace();

		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

}
