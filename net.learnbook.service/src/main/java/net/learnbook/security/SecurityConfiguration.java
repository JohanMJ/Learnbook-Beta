package net.learnbook.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}*/

	/*
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
	 */


	//CSRF Referente a token.
/*	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").permitAll().antMatchers("dev").permitAll();
		http.csrf()
			.disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}*/
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/dev/user/get/{iCodUser}").permitAll()
			.antMatchers("/dev/group/get/{iCodGru}").permitAll()
			.antMatchers("/dev/course/list/group/{iCodGru}").permitAll()
			.antMatchers("/dev/user/insert").permitAll()
			.antMatchers("/dev/user/update").permitAll()
			.antMatchers("/dev/course/buy/{iCodCou}").permitAll()
			.antMatchers("/dev/course/insert").permitAll()
			.antMatchers("/dev/group/insert").permitAll()
			.antMatchers("/dev/course/update").permitAll()
			.antMatchers("/dev/course/remove").permitAll()
			.antMatchers("/dev/course/getPoints/From/{iCodCou}").permitAll()
			.antMatchers("/dev/activity/insert").permitAll()
			.antMatchers("/dev/activity/finish").permitAll()
			.antMatchers("/dev/activity/list/{iCodCou}").permitAll()
			.antMatchers("/dev/user/listAll").permitAll()
			.antMatchers("/dev/user/listAll/{iCodUser}").permitAll()
			.antMatchers("/dev/course/listAll").permitAll()
			.antMatchers("/dev/course/progress/{iCodCou}").permitAll()
			.antMatchers("/dev/group/listAll").permitAll()
			.antMatchers("/dev/group/listAll/{iCodUser}").permitAll()
			.antMatchers("/dev/user/login/{sLogin}").permitAll()
			.antMatchers("/dev/course/list/{iCodUser}").permitAll()
			.antMatchers("/dev/course/list/single/{iCodCou}").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
		
		// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
		
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
/*		 auth
         .jdbcAuthentication()
             .dataSource(datasource)
             .usersByUsernameQuery("SELECT sLogUser, sPasUser from User where sLogUser=? ")
             .authoritiesByUsernameQuery("SELECT sLogUser, role from ROLE WHERE sLogUser=? ");*/
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
		.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
		
		/*auth.inMemoryAuthentication()
		.withUser("admin@gmail.com")
		.password("$10$qm17OjcrV2/hRmskASu0CuxwJsUVsq5vOG.qkRzt7foe.8niuzmhK")
		.roles("ADMIN");*/
	}
	


}