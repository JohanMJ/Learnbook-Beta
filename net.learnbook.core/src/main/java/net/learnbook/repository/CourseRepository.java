package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Course;

@Repository
public class CourseRepository extends AbstractRepository<Course>{

	public CourseRepository() {
		super(Course.class);
	}
	
	

}
