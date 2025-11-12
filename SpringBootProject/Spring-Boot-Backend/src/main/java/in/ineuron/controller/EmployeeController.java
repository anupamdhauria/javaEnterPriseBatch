package in.ineuron.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Employee;
import in.ineuron.service.IEmpMgmtService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private IEmpMgmtService service;
	
	@GetMapping(value="/employees",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee>getAllEmployees(){
		List<Employee> employees = service.findAllEmployees();
		return employees;
	}
	
	@PostMapping("/employees")
	public Employee registerEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer Id) {
		Employee employee = service.findEmployeeById(Id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee>updateEmployeeById(@PathVariable("id") Integer Id,@RequestBody Employee employee){
		
		Employee empDB = service.findEmployeeById(Id);
		
		empDB.setFirstName(employee.getFirstName());
		empDB.setLastName(employee.getLastName());
		empDB.setEmailId(employee.getEmailId());
		
		Employee employeeUpdate=service.saveEmployee(empDB);
		return ResponseEntity.ok(employeeUpdate);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?>updateEmployeeById(@PathVariable("id") Integer Id){
		
		service.deleteEmployeeById(Id);
		HashMap<String,Boolean>response=new HashMap<>();
		response.put("deleted", true);
		return ResponseEntity.ok(response);
	}
}
