package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/greet")
public class DemoController {

	@Autowired
	private Environment env;
	@GetMapping("/welcome")
	public ResponseEntity<String>welcome(){
		String msg="Welcome to Spring Boot Microservices Courses";
		String portNo = env.getProperty("local.server.port");
		msg=msg.concat(",and port number is ::"+portNo);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
