package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Employee;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {

	@PostMapping("/register")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		
		System.out.println(employee);
		return new ResponseEntity<String>("employee data saved",HttpStatus.OK);
	}
}
