package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ms1")
public class EurekaController {

	@GetMapping("/hi/{name}")
	public String GetMsg(@PathVariable String name) {
		return "Hii"+"  "+name+" How are you??";
	}
}
