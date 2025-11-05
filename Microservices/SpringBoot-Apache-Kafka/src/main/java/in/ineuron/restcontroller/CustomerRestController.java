package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;
import in.ineuron.service.CustomerKafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class CustomerRestController {
	
	@Autowired
	private CustomerKafkaProducer service;

	@PostMapping(value="/add")
	public ResponseEntity<String>sendCustomerData(@RequestBody List<Customer> customers){
		String msg = service.add(customers);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
