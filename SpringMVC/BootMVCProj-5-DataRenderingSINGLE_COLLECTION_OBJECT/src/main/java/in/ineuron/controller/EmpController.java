package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.ineuron.model.Employee;

@Controller
public class EmpController {

	@GetMapping
	public String showHome() {
		return "home";
	}
	
	@GetMapping(value="/report")
	public String showReport(Map<String,Object>model) {
		
		List<Employee>employees=List.of(new Employee(1,"Anupam","Developer",345555.0),
				new Employee(2,"Akash","Consultant",837339.0),
				new Employee(3,"Ravi","Team lead",5363233.0));
		model.put("employees", employees);
		
//		single object
		Employee employee = new Employee(45,"Sunil","Manager",45552.20);
		model.put("employee",employee);
		
		return "show_report";
	}
}
