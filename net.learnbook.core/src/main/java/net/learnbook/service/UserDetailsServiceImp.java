package net.learnbook.service;



import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.learnbook.repository.UserRepository;


@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository) {
    	System.out.println("AQUI 5");
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("asdsadas" +username);
    	username = "sucesso@gmail.com";
    	net.learnbook.entity.User applicationUser = userRepository.loadUserByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println(new User(applicationUser.getsLogUser(), applicationUser.getsPasUser(), emptyList()).getUsername());
        return new User(applicationUser.getsLogUser(), applicationUser.getsPasUser(), emptyList());
    }
}