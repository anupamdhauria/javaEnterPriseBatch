package in.ineuron.restcontroller;

import java.util.Random;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/order")
public class SampleRestController {

    @GetMapping("/show")
    @CircuitBreaker(name = "orderdetails", fallbackMethod = "showFallBack")
    public String getOrderDetails() {
        System.out.println("SampleRestController.getOrderDetails()");
        if (new Random().nextInt(10) < 10) {
            throw new RuntimeException("Dummy Error");
        }
        return "Hello From Provider";
    }

    public String showFallBack(Exception e) {
        System.out.println("SampleRestController.showFallBack()");
        return "Hii From Fallback: " + e.getMessage();
    }
}