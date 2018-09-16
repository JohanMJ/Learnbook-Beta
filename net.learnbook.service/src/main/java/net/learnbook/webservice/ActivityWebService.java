package net.learnbook.webservice;

import java.util.ArrayList;
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

@RestController
@CrossOrigin(origins="*")
@RequestMapping("dev/activity")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityWebService {

	@Autowired
	private ActivityService activityService;

	@PostMapping("insert")
	public ResponseEntity<Activity> insertActivity(@RequestBody Activity activity) {
		try {
			activityService.insert(activity);
			return new ResponseEntity<Activity>(activity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@PutMapping("update")
	public void updateActivity(@RequestBody Activity activity) {
		try {
			activityService.update(activity);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("finish")
	public void finishActivity(@RequestBody Activity activity) {
		try {
			activity.setsConAct("x");
			activityService.update(activity);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/list/{iCodCou}")
	public List<Activity> getActivitiesFromCourse(@PathVariable Integer iCodCou) {
		try {
			List<Activity> activities = new ArrayList<Activity>();
			activities = activityService.listActivitiesFromCourse(iCodCou);
			return activities;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
}
