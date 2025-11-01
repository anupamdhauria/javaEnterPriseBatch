package in.ineuron.restcontroller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("api/order")
public class SampleRestController {

	@GetMapping("/show")
	@HystrixCommand(fallbackMethod = "showFallBack")
	public String getOrderDetails() {
		System.out.println("SampleRestController.getOrderDetails()");
		if(new Random().nextInt(10)<10) {
			throw new RuntimeException("Dummy Error");
		}
		return "Hello From Provider";
	}
	
	public String showFallBack() {
		System.out.println("SampleRestController.showFallBack()");
		return "Hii From Fallback";
	}
}
