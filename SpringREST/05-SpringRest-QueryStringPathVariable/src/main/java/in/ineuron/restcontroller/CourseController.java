package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

	@GetMapping("/info/{id}")
	public ResponseEntity<String> getCourse(@PathVariable Integer id){
		
		String body=null;
		
		if (id == 5) {
			body = "SpringBoot-MicroServices batch from Syed Haider from May23-2023 @9.00AM";
		} else if (id == 6) {
			body = "Java Real Time Project batch from Navin Reddy from June12-2023 @6.30AM";
		} else {
			body = "Contact ineuron webiste for the information";
		}
		
		ResponseEntity<String> empEntity = new ResponseEntity<>(body,HttpStatus.OK);
		return empEntity;
	}
	
	
	@GetMapping("/info/{id}/teacher/{name}")
	public ResponseEntity<String>getCourseDetails(@PathVariable Integer id,@PathVariable String name){
		String body=null;
		if (id==5 && name.equalsIgnoreCase("navinreddy")) {
			body = "Java Real Time Project batch from Navin Reddy from June12-2023 @6.30AM";
		} else if (id==6 && name.equalsIgnoreCase("haider")) {
			body = "Java Real Time Project batch from Syed Haider from May23-2023 @9.00AM";
		} else {
			body = "Contact ineuron webiste for the information";
		}
		ResponseEntity<String> empEntity = new ResponseEntity<>(body,HttpStatus.OK);
		return empEntity;
	}
}
