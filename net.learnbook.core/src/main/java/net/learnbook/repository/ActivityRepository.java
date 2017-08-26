package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Activity;

@Repository
public class ActivityRepository extends AbstractRepository<Activity>{

	public ActivityRepository() {
		super(Activity.class);
	}
	
	

}
