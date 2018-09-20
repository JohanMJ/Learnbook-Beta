package net.learnbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Course;
import net.learnbook.repository.CourseRepository;

@Service
@Primary
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void insert(Course course) {
		courseRepository.save(course);
	}

	@Override
	public Course findById(Integer iCodCou) {
		return courseRepository.findById(iCodCou);
	}

	@Override
	public CourseRepository getRepository() {
		return courseRepository;
	}

	@Override
	public List<Course> listCourseByUser(Integer iCodUser) {
		return courseRepository.listCourseByUser("Course", iCodUser);
	}

	@Override
	public List<Course> listAll() {
		return courseRepository.list("Course");
	}

	@Override
	public void update(Course course) {
		courseRepository.update(course);
	}

}
