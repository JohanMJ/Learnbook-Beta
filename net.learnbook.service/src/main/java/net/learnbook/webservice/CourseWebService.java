package net.learnbook.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.learnbook.entity.Course;
import net.learnbook.service.CourseService;

@RestController
@CrossOrigin(origins = "*")
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
			course.setsStaCou("Inicial");
			courseService.insert(course);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping(value = "/list/single/{iCodCou}")
	public Course getCourse(@PathVariable Integer iCodCou) {
		try {

			return courseService.findById(iCodCou);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/list/{iCodUser}")
	public List<Course> getCourseByUser(@PathVariable Integer iCodUser) {
		try {
			List<Course> courses = new ArrayList<Course>();
			courses = courseService.listCourseByUser(iCodUser);
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@GetMapping(value="listAll")
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.listAll();
		return courses;
	            
	}

}
