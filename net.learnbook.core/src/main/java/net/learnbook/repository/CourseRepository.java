package net.learnbook.repository;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Course;

@Repository
public class CourseRepository extends AbstractRepository<Course>{

	public CourseRepository() {
		super(Course.class);
	}
	
	

/*	@SuppressWarnings("unchecked")
	public List<Course> listCourseByUser(Integer iCodUser) {
		try {
			String className = "course_user";
			String selectQuery = "FROM " + className + " as cu INNER JOIN course as c ON cu.iCodCou = c.iCodCou WHERE cu.iCodUser = :iCodUser";
			Query query = this.entityManager.createQuery(selectQuery);
			query.setParameter("iCodUser", iCodUser);
				
			System.out.println(selectQuery);
			return (List<Course>) query.getResultList();

		} catch (IllegalArgumentException error) {
			error.printStackTrace();

		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}
	*/

}
