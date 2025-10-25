package in.ineuron.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner runner() {
		//Annonomous class style
		/*
		 * return new CommandLineRunner() {
		 * 
		 * @Override public void run(String... args) throws Exception {
		 * 
		 * System.out.println("Arguments are::"+Arrays.asList(args));
		 * 
		 * } };
		 */
			
		
		//lamda expression
		
		/*
		 * return (args)->{ System.out.println("Arguments are::"+Arrays.asList(args));
		 * };
		 */
		
		//method reference 
		
		return  AppConfig::runnerMethodRef;
		
		
	}
	
	public static void runnerMethodRef(String... args) {
		System.out.println("Arguments are::"+Arrays.asList(args));
	}

}
