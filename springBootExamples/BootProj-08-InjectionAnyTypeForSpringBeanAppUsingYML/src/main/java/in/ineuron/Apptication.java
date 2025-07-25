package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Employee;


@SpringBootApplication
public class Apptication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Apptication.class, args);
		Employee employee = context.getBean(Employee.class);
		System.out.println(employee);
		((ConfigurableApplicationContext) context).close();
	}

}
