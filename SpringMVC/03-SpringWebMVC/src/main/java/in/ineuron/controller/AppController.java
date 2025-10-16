package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@GetMapping("/greeting")
	public String displayOther(Model model) {
		model.addAttribute("message", "All the best..");
		return "index";
	}
}
