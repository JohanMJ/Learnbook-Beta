package net.learnbook.webservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.learnbook.entity.Course;
import net.learnbook.service.CourseService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping("dev/course")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseWebService {

	@Autowired
	private CourseService courseService;

	@PostMapping("insert")
	public ResponseEntity<Course> insertCourse(@RequestBody Course course) {
		try {
			course.setdDatCou(new Date());
			course.setdExpTimCou(new Date());
			course.setsStaCou("nice");
//			course.sets
			System.out.println(course);
			courseService.insert(course);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

//	@GetMapping("list")
//	public ResponseEntity<Course> getCourse() {
//
////		Course course = new Course(1, "Curso 01", "Teste - Curso 01", new Date(), new Date(), 99.99f, null, null, null);
//
//		return new ResponseEntity<Course>(course, HttpStatus.OK);
//
//	}

}
