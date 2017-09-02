package net.learnbook.webservice;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.learnbook.entity.Role;
import net.learnbook.entity.User;
import net.learnbook.service.UserService;

@Controller
@CrossOrigin(origins="*")
@RequestMapping("dev/user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWebService {

	@Autowired
	private UserService userService;
	
	@PostMapping("insert")
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		try{
			userService.insert(user);  
            return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
                
	}
	@GetMapping("list")
	public ResponseEntity<User> getUser() {
		
			User user = new User(null, "ola", " master@gmail.com", "123456", new Date(), true, null, null);
			
			Role userRole = new Role(1, "admin");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
                
	}
	

		

}
