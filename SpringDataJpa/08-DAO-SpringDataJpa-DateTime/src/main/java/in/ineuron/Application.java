package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.Customer;

import in.ineuron.service.ICustomerMgmtService;

import jakarta.persistence.EntityNotFoundException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		ICustomerMgmtService service = factory.getBean(ICustomerMgmtService.class);

		Customer customer = new Customer("dravid", "RCB", LocalDateTime.of(1997, 04, 30, 10, 50, 20),
				LocalTime.of(10, 45), LocalDate.now());

		String status = service.registerCustomer(customer);
		System.out.println(status);

		System.out.println();

		service.getAllCustomers().forEach(System.out::println);

		factory.close();

	}

}
