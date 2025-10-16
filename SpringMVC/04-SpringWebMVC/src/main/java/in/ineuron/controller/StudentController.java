package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.model.Student;

@Controller
public class StudentController {

	@GetMapping("/studetails")
	public String getData(Model model) {
		
		Student std = new Student();
		std.setCity("Jsr");
		std.setFirstName("Anupam");
		std.setGender("Male");
		std.setLastName("Dhauria");
		std.setId(1);
		model.addAttribute("std",std);
		return "student";
		
	}
}
