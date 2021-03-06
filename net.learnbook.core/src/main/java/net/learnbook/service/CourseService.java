package net.learnbook.service;

import java.util.List;

import net.learnbook.entity.Course;
import net.learnbook.repository.CourseRepository;

public interface CourseService {

	public void insert(Course course);
	
	public void update(Course couse);

	public Course findById(Integer iCodCou);
	
	public List<Course> listAll();

	public List<Course> listCourseByUser(Integer iCodUser);

	public CourseRepository getRepository();
}
