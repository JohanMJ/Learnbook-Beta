package net.learnbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Activity;
import net.learnbook.repository.ActivityRepository;

@Service
@Primary
public class ActivityServiceImp implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void insert(Activity activity) {
		activityRepository.save(activity);
	}
	
	@Override
	public void update(Activity activity) {
		activityRepository.update(activity);
		
	}
	
	@Override
	public List<Activity> getActivitiesFromReview() {
		return activityRepository.getActivitiesFromReview("Activity");
	}

	@Override
	public ActivityRepository getRepository() {
		return activityRepository;
	}

	@Override
	public List<Activity> listActivitiesFromCourse(Integer iCodCou) {
		
		return activityRepository.listActivitiesFromCourse("Activity", iCodCou);
	}



}
