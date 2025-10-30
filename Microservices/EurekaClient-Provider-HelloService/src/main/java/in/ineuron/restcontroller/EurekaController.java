package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

	@GetMapping("/hello/{name}")
	public String GetMsg(@PathVariable String name) {
		return "Hello"+"  "+name+" How are you??";
	}
}
