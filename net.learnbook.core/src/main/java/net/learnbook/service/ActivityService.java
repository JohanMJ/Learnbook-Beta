package net.learnbook.service;

import net.learnbook.entity.Activity;
import net.learnbook.repository.ActivityRepository;

public interface ActivityService {

	public void insert(Activity activity);
	
	public ActivityRepository getRepository();
}
