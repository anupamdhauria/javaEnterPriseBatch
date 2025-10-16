package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.StudentServiceImpl;

@SpringBootApplication
public class DaoProject5SpringBootJdbcCallbackBeanPropertyRowApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DaoProject5SpringBootJdbcCallbackBeanPropertyRowApplication.class, args);
		StudentServiceImpl student = context.getBean(StudentServiceImpl.class);
		StudentDTO studentById = student.fetchStudentById(4);
		System.out.println(studentById);
		System.out.println("==================================================================");
		List<StudentDTO> stduents = student.fetchStudentByName("anupam", "sourav");
		stduents.forEach(System.out::println);
		System.out.println("==================================================================");
		student.fetchStuentByCity("galudih", "jamshedpur", "csk").forEach(System.out::println);
		System.out.println("==================================================================");
		context.close();
		
	}

}
