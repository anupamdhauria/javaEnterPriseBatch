package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/wish")
public class WishController {
	
	@GetMapping("/msg")
//	@ResponseBody
	public ResponseEntity<String> generateMessage(){
		
		LocalDateTime lt=LocalDateTime.now();
		
		int hour=lt.getHour();
		
		String body=null;
		if(hour<12)
			body="Good Morning";
		else if(hour<16)
			body="Good Afternoon";
		else if(hour<20)
			body="Good Evening";
		else
			body="Good Night";
		
		ResponseEntity<String> entity = new ResponseEntity<>(body,HttpStatus.OK);
		return entity;
		
	}

}
