package in.ineuron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.ineuron.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public  void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
	
	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception{
	
		http.authorizeHttpRequests().antMatchers("/bank/").permitAll()
		.antMatchers("/user/register", "/user/showLogin").permitAll()
		.antMatchers("/bank/offers").authenticated()
		.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")
		.antMatchers("/bank/loanApprove").hasAuthority("MANAGER")
		.anyRequest().authenticated()
		
		.and().formLogin()
		.defaultSuccessUrl("/bank/",true)//home page url
		.loginPage("/user/showLogin") //for GET mode request to launch form page
		.loginProcessingUrl("/login") //for POST mode request to submit and process the page
		.failureUrl("/user/showLogin?error")//Authentication failed url
		
		.and().rememberMe()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.logoutSuccessUrl("/user/showLogin?logout") //after logout url
		
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);

		
		return http.build();
	}
}
