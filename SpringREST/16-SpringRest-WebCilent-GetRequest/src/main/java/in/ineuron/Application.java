package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.CurrencyService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext bean = SpringApplication.run(Application.class, args);
		CurrencyService cbean = bean.getBean(CurrencyService.class);
		System.out.println("===============================================================");
		cbean.invokeApiSync("USD", "INR");
		System.out.println("===============================================================");
		cbean.invokeApiASync("USD", "INR");
	}

}
