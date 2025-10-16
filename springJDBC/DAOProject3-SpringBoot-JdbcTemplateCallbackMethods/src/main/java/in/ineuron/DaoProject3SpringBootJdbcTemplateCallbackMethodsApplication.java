package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.StudentServiceImpl;

@SpringBootApplication
public class DaoProject3SpringBootJdbcTemplateCallbackMethodsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DaoProject3SpringBootJdbcTemplateCallbackMethodsApplication.class, args);
		StudentServiceImpl student = context.getBean(StudentServiceImpl.class);
		StudentDTO studentById = student.fetchStudentById(3);
		System.out.println(studentById);
		
		List<StudentDTO> stduents = student.fetchStudentByName("anupam", "ayushi");
		stduents.forEach(System.out::println);
		context.close();
		
	}

}
