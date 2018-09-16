package net.learnbook.service;

import java.util.List;

import net.learnbook.entity.Activity;
import net.learnbook.repository.ActivityRepository;

public interface ActivityService {

	public void insert(Activity activity);
	
	public void update(Activity activity);
	
	public List<Activity>  listActivitiesFromCourse(Integer iCodCou);
	
	public ActivityRepository getRepository();
}
