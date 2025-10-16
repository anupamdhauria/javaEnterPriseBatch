package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user1")
public class FirstController {
	
	@RequestMapping("/welcome")
	public ModelAndView displayMsg() {
		
		ModelAndView view = new ModelAndView();
		view.addObject("message","Welcome to spring web mvc ");
		view.setViewName("index");
		return view;
	}
	
	@GetMapping("/user")
	public String display(Model model) {
		model.addAttribute("message", "Welcome Anupam");
		return "index";
	}
	
	@GetMapping
	public String getName(Model model) {
		model.addAttribute("message","Welcome Learner");
		return "index";
	}
	
	@PostMapping
	public String getName2(Model model) {
		model.addAttribute("message", "Welcome Here");
		return "index";
	}

}
