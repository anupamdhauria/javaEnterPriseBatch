package in.ineuron.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class ActorsServiceConsumingRunnerPathVariable implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorsServiceConsumingRunnerPathVariable.run()");
		RestTemplate template = new RestTemplate();
		String url="http://localhost:8888/12-SpringRest-Provider/api/actor/wish/{id}/{name}";
		
		
		ResponseEntity<String> response = template.exchange(url,HttpMethod.GET,null,String.class,7,"dhoni");
		
		System.out.println("ResponseBody              :: " + response.getBody());
		System.out.println("ResponseStatus Code       :: " + response.getStatusCode().toString());
		System.out.println("********************************************************");
	}

}
