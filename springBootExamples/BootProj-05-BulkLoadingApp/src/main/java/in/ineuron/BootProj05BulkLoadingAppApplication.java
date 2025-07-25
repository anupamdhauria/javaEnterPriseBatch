package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Company;

@SpringBootApplication
public class BootProj05BulkLoadingAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootProj05BulkLoadingAppApplication.class, args);
		Company company = context.getBean(Company.class);
		System.out.println(company);
		context.close();
	}

}
