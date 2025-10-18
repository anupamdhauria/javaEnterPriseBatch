package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.model.Employee;

@Controller
public class EmpController {

	@GetMapping("/register")
	public String showHome(@ModelAttribute("emp")Employee employee) {
		return "home";
	}
	
	@PostMapping(value="/register")
	public String showReport(Map<String,Object>model, @ModelAttribute("emp") Employee employee) {
		System.out.println("EmployeeController.registerEmployee()");
		System.out.println(employee);
		model.put("employee",employee);
		
		return "result";
	}
}
