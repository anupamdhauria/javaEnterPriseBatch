package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.EmployeeMgmntServiceImpl;

@SpringBootApplication
public class DaoProject2SpringBootJdbcTemplateDirectMethodApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DaoProject2SpringBootJdbcTemplateDirectMethodApplication.class, args);
		EmployeeMgmntServiceImpl emp = context.getBean(EmployeeMgmntServiceImpl.class);
		
		List<Map<String,Object>>map=emp.getEmployeeDetailsByDesignation("batsman", "keeper");
		map.forEach(System.out::println);
		context.close();
	}

}
