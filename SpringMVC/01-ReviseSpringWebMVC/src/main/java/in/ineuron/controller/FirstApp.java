package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FirstApp {

	@RequestMapping("/welcome")
	public ModelAndView getMessage() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("message","first application");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/java")
	public String display(Model model) {
		
		 model.addAttribute("message","spring boot is awesome");
		 return "index";
		 
	}
}
