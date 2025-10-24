package in.ineuron.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Actor;

@Controller
public class ActorsServiceConsumingRunnerGetJsonData implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorsServiceConsumingRunnerGetJsonData.run()");
		RestTemplate template = new RestTemplate();
		String url="http://localhost:8888/12-SpringRest-Provider/api/actor/find/{id}";
		
		
		
		ResponseEntity<Actor> response = template.exchange(url, HttpMethod.GET,null,Actor.class,12);
		
		System.out.println("ResponseBody              :: " + response.getBody());
		System.out.println("ResponseStatus Code       :: " + response.getStatusCode().toString());
		System.out.println("********************************************************");
	}

}
