package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("EurekaClient1-HelloService")
public interface IEurekaClient {

	@GetMapping("/hello/{name}")
	public String invokeHelloService(@PathVariable String name);
}
