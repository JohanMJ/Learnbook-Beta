package net.learnbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http. authorizeRequests() .antMatchers("/").permitAll()
	 * .antMatchers("/login").permitAll()
	 * .antMatchers("/registration").permitAll()
	 * .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
	 * .authenticated().and().csrf().disable().formLogin()
	 * .loginPage("/login").failureUrl("/login?error=true")
	 * .defaultSuccessUrl("/admin/home") .usernameParameter("email")
	 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout"))
	 * .logoutSuccessUrl("/").and().exceptionHandling()
	 * .accessDeniedPage("/access-denied"); }
	 

	
	//CSRF Referente a token.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").permitAll().antMatchers("dev").permitAll();
		http.csrf()
			.disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	*/
	//Test - Authentication
	
	 private UserDetailsService userDetailsService;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    public SecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
	                .antMatchers(HttpMethod.GET, "/dev/user/listAll").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
	    }

	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	try {
				System.out.println("QUI 3");
				auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	  @Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }

}