package net.learnbook.service;

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
	public CourseRepository getRepository() {
		return courseRepository;
	}

}
