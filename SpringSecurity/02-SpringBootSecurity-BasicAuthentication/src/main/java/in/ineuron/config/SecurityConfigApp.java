package in.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigApp {
	static {
		System.out.println("SecurityConfigApp.class is loading...");
	}
	public SecurityConfigApp() {
		System.out.println("SecurityConfigApp.SecurityConfigApp()");
	}

	@Bean
	public SecurityFilterChain userDefindedFilter(HttpSecurity http ) throws Exception {
		
		System.out.println("SecurityConfigApp.userDefindedFilter()");
		http.authorizeHttpRequests(request->request.requestMatchers("/bank/","/bank/aboutus","/login").permitAll().anyRequest().authenticated()).formLogin(Customizer.withDefaults());
		
		return http.build();
	}
}
