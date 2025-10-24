package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.TicketService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext bean = SpringApplication.run(Application.class, args);
		TicketService tbean = bean.getBean(TicketService.class);
		System.out.println("===========================================================");
		tbean.invokeTicketApi();
		System.out.println("===========================================================");
		bean.close();
	}

}
