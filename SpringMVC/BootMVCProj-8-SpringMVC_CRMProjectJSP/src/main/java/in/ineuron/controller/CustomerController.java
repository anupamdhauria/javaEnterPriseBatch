package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	@GetMapping("/list")
	public String listCustomers(Map<String,Object> model) {
		List<Customer> customers = service.getCustomers();
		System.out.println(customers);
		model.put("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormAdd() {
		return "customer-form";
	}
}
