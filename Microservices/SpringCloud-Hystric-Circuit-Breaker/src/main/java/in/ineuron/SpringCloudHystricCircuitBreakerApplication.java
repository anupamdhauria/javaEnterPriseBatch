package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudHystricCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystricCircuitBreakerApplication.class, args);
	}

}
