package net.learnbook.service;

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
	public ActivityRepository getRepository() {
		return activityRepository;
	}

}
