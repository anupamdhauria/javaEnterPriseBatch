package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
	
	@RequestMapping("/welcome")
	public ModelAndView displayMsg() {
		
		ModelAndView view = new ModelAndView();
		view.addObject("message","Welcome to spring web mvc yoo");
		view.setViewName("index");
		return view;
	}
	
	@GetMapping("/user")
	public String display(Model model) {
		model.addAttribute("message", "Hey Anupam");
		return "index";
	}

}
