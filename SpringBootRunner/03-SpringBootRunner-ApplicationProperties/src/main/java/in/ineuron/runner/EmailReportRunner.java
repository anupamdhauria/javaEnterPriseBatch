package in.ineuron.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class EmailReportRunner implements ApplicationRunner {
	
	
	@Value("${spring.application.name}")
	String name;
 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailReportRunner.run()");
		
		System.out.println("value is::"+name);
		
	}

	

}
