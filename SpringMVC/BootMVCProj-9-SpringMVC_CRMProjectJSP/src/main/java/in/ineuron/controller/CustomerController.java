package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showFormAdd(Map<String,Object>model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		System.out.println(customer);
		service.registerCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId")Integer customerId,Map<String,Object>model) {
		Customer customer = service.getCustomer(customerId);
		model.put("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/showFormDelete")
	public String showFormDelete(@RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
