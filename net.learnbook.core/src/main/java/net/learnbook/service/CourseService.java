package net.learnbook.service;



import java.util.List;

import net.learnbook.entity.Course;
import net.learnbook.repository.CourseRepository;

public interface CourseService {

	public void insert(Course course);
	
	public List<Course> listCourseByUser(Integer iCodUser);
	
	public CourseRepository getRepository();
}
