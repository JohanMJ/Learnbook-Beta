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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.learnbook.entity.Activity;
import net.learnbook.entity.Course;
import net.learnbook.service.ActivityService;
import net.learnbook.service.CourseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("dev/course")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseWebService {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ActivityService activityService;

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

	@GetMapping(value = "/listAll")
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.listAll();
		return courses;

	}

	@GetMapping(value = "/progress/{iCodCou}")
	public double getProgress(@PathVariable Integer iCodCou) {
		double progress = 0;
		try {

			System.out.println(progress);
			List<Activity> activities = new ArrayList<Activity>();
			activities = activityService.listActivitiesFromCourse(iCodCou);
			Integer numAct = activities.size();
			Integer syTabix = 1;
			for (Activity act : activities) {
				if (act.getsConAct() != null) {
					if (act.getsConAct().equalsIgnoreCase("X")) {
						System.out.println(progress + " " + syTabix + " " + numAct);
						progress = (double) syTabix / numAct;
//					progress = 50;
						progress = (double) progress * 100;
						syTabix++;
						System.out.println(syTabix);
					}
				}

			}
			System.out.println(progress);
			return (double) progress;
		} catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}

	}

	@PutMapping("update")
	public void updateCourse(@RequestBody Course course) {
		try {
			courseService.update(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("remove")
	public void removeCourse(@RequestBody Course course) {
		try {
			course.setsStaCou("R");
			courseService.update(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/getPoints/From/{iCodCou}")
	public float getPointsFromCourse(@PathVariable Integer iCodCou) {
		float points = 0f;
		Course c = new Course();
		c = courseService.findById(iCodCou);

			if(c.getfHorCou() != 0 && c.getfPriCou() != 0) {
				points = ( c.getfHorCou() * c.getfPriCou() ) / 200f;
				return points;
			}
		
		return points;

	}

}
