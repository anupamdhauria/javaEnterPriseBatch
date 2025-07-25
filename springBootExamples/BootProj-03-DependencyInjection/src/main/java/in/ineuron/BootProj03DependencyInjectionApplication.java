package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.Student;

@SpringBootApplication
public class BootProj03DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj03DependencyInjectionApplication.class, args);
		Student student = context.getBean(Student.class);
		System.out.println(student);
		student.preparation();
		((ConfigurableApplicationContext) context).close();
		
	}

}
