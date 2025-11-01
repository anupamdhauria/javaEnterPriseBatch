package in.ineuron.restcontroller;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.config.AppConfig;
import in.ineuron.constants.AppConstants;

@RestController
@RequestMapping("/api/test")
public class SampleRestController {

	@Autowired
	private AppConfig config;
	
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("SampleRestController.welcome()");
		Map<String, String> prop = config.getProps();
		for(Map.Entry<String,String>entry:prop.entrySet()) {
			System.out.println("key:"+entry.getKey());
			System.out.println("value:"+entry.getValue());
		}
		return config.getProperties().get(AppConstants.WELCOME_MSG);
	}
	
	@GetMapping("/testmsg")
	public String testMsg() {
		System.out.println("SampleRestController.testMsg()");
		Map<String, String> prop = config.getProps();
		for(Map.Entry<String,String>entry:prop.entrySet()) {
			System.out.println("key:"+entry.getKey());
			System.out.println("value:"+entry.getValue());
		}
		return config.getProps().get(AppConstants.TEST_MSG);
	}
}
