package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@GetMapping("/read")
	public ResponseEntity<String> getEmployee(@RequestParam Integer id,@RequestParam String name){
		
		String body=null;
		
		if(id==7 && name.equalsIgnoreCase("dhoni")) {
			body=id+" "+name+"=============>CSK";
		}else if(id==18 && name.equals("kohli")) {
			body=id+" "+name+"=============>RCB";
		}else {
			body=id+" "+name+"=============>OTHER TEAM";
		}
		
		ResponseEntity<String> empEntity = new ResponseEntity<>(body,HttpStatus.OK);
		return empEntity;
	}
}
