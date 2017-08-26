package net.learnbook.service;



import net.learnbook.entity.Course;
import net.learnbook.repository.CourseRepository;

public interface CourseService {

	public void insert(Course course);
	
	public CourseRepository getRepository();
}
