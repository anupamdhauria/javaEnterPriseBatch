package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankRestController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to ICICI Bank";
	}
}
