package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user2")
public class SecondController {

	@GetMapping("/user")
	public String displayOther(Model model) {
		model.addAttribute("message", "welcome Rajiv");
		return "index";
	}
}
