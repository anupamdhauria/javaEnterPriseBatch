package in.ineuron;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication();
		application.setBannerMode(Mode.CONSOLE);
		
		SpringApplication.run(Application.class, args);
	}

}
