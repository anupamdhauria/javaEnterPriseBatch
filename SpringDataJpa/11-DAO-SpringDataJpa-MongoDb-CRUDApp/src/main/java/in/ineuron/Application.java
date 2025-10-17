package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.repository.ICustomerRepo;
import in.ineuron.service.ICustomerServiceMgmt;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		
		ICustomerServiceMgmt service = factory.getBean(ICustomerServiceMgmt.class);
		
		
		/*
		 * String customer = service.registerCustomer(null, new
		 * CustomerDTO(17,"ramesh",961.46f)); System.out.println(customer);
		 * 
		 * service.findAllCustomers().forEach(System.out::println);
		 * 
		 * String customer1 = service.registerCustomer("01f0b48ee9", new
		 * CustomerDTO(7,"msd",345.46f)); System.out.println(customer1);
		 * service.findAllCustomers().forEach(System.out::println);
		 * System.out.println(service.removeCustomer("68f1eb5e070d6ac265a46413"));
		 */
		
//		service.fetchByBillAmtBetween(200.0f, 1000.0f).forEach(System.out::println);
	
		
		service.fetchByCnameInAndhavingBillAmt("sachin","kohli","msd").forEach(System.out::println);
		factory.close();
	}

}
