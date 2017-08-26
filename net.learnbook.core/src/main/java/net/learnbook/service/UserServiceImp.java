package net.learnbook.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Role;
import net.learnbook.entity.User;
import net.learnbook.repository.RoleRepository;
import net.learnbook.repository.UserRepository;

@Service
@Primary
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void insert(User user) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;

		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(user.getsPasUser());

		user.setsPasUser(cryptedPassword);
		user.setbStaUser(true);

		if (user.getdBirUser() == null) {
			long now = GregorianCalendar.getInstance().getTimeInMillis();
			user.setdBirUser(new Date(now));
		}

		Role userRole = roleRepository.findById(0);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);


	}

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

}
