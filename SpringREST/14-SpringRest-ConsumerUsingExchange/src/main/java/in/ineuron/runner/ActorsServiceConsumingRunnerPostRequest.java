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

@Controller
public class ActorsServiceConsumingRunnerPostRequest implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("ActorsServiceConsumingRunnerPostRequest.run()");
		RestTemplate template = new RestTemplate();
		String url="http://localhost:8888/12-SpringRest-Provider/api/actor/register";
		
		HttpHeaders headers = new HttpHeaders();		
		headers.setContentType(MediaType.APPLICATION_JSON);
		String json_data = "{\r\n" + "    \"aid\":18,\r\n" + "    \"name\":\"kohli\",\r\n" + "    \"age\":38,\r\n"
				+ "    \"type\":\"crickter\"\r\n" + "}";
		HttpEntity request = new HttpEntity(json_data,headers);
		ResponseEntity<String> response = template.exchange(url,HttpMethod.POST,request,String.class);
		
		System.out.println("ResponseBody              :: " + response.getBody());
		System.out.println("ResponseStatus Code       :: " + response.getStatusCode().toString());
		System.out.println("********************************************************");
	}

}
