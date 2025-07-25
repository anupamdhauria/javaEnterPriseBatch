package in.ineuron;

import in.ineuron.comp.WishMessageGenerator;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProj02DependencyInjectionApplication {

	static {
		System.out.println("BootProj02DependencyInjectionApplication file is loading");
	}
	public BootProj02DependencyInjectionApplication() {
		System.out.println("BootProj02DependencyInjectionApplication:zero arg constructor");
	}

    @Bean(value="date")
	public LocalDateTime createTimeObj() 
	{
    	System.out.println("BootProj02DependencyInjectionApplication.createTimeObj()");
		return LocalDateTime.now();
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		System.out.println(context);
		
		WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		System.out.println(wmg);
		
		System.out.println(wmg.greetMessage("ANUPAM"));
		
	}

}
