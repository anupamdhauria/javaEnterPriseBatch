package in.ineuron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	public void configurableAuthorities(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("sachin").password("{noop}sachin@123").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh@123").roles("MANAGER");
		
	}
   
	@Bean
    public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/offers").authenticated()
                .antMatchers("/loanApprove").hasRole("MANAGER")
                .antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/denied")
                .and().rememberMe()
                .and().logout()
                .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);       
        return http.build();
    }
}