package net.learnbook.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Role;
import net.learnbook.entity.User;
import net.learnbook.repository.RoleRepository;
import net.learnbook.repository.UserRepository;

@Service
@Primary
public class UserServiceImp implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void insert(User user) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;

		System.out.println(user);
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(user.getsPasUser());

		user.setsPasUser(cryptedPassword);
		user.setbStaUser(true);

		if (user.getdBirUser() == null) {
			long now = GregorianCalendar.getInstance().getTimeInMillis();
			user.setdBirUser(new Date(now));
		}

/*		Role userRole = roleRepository.findById(0);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));*/
		userRepository.save(user);

	}

	@Override
	public List<User> listAll() {
		List<User> users = userRepository.list("User");

		if (users == null)
			try {
				throw new Exception("Doesn`t have recipes to list");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return users;
	}

	@Override
	public User findById(Integer iCodUser) {

		return userRepository.findById(iCodUser);
	}
	

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public UserDetails loadUserByUsername(String sLogUser) throws UsernameNotFoundException {
	User user;
		
		user = userRepository.loadUserByUsername(sLogUser);
		
		if( user == null)
			throw new UsernameNotFoundException("Usuário não encontrado.");
	    
		return user;
	}*/

}
