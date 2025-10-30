package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IEurekaClient;

@RestController
@RequestMapping("/api/ms1")
public class EurekaController {

	@Autowired
	private IEurekaClient client;
	
	
	@GetMapping("/hi/{name}")
	public String GetMsg(@PathVariable String name) {
		System.out.println("Implementation class is ::"+client.getClass().getName());
		String msg = client.invokeHelloService(name);
		
		return "Hii"+"  "+name+" How are you??"+"\n"+msg;
		
	}
}
