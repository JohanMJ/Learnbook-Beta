package net.learnbook.webservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.learnbook.entity.Activity;
import net.learnbook.service.ActivityService;

@Controller
@RequestMapping("dev/activity")
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

	@GetMapping("list")
	public ResponseEntity<Activity> getActivity() {

		Activity activity = new Activity(1, "Atividade 01", "Teste - Atividade 01", new Date(), new Date());
		return new ResponseEntity<Activity>(activity, HttpStatus.OK);

	}

}
