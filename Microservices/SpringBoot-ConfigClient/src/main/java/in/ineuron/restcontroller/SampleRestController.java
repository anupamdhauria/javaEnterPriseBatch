package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/configClient")
public class SampleRestController {
	
	@Value("${msg:Config Server not working , plz check...}")
	private String msg;

	@GetMapping("/greet")
	public ResponseEntity<String>welcome()
	{
	
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
