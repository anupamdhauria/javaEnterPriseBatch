package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.service.IStudentMgmtService;
import jakarta.persistence.EntityNotFoundException;

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		
		IStudentMgmtService service = factory.getBean(IStudentMgmtService.class);
		service.fetchByname("anupam", "sourav").forEach(System.out::println);;
		factory.close();

	}

}
