package in.ineuron.cfg;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI createOpenApi() {
		
		return new OpenAPI().info(new Info().title("Tourist APIs")
				.description("Give Information about Tourist Activities")
				.license(new License().name("GNU Public"))
				.termsOfService("https")
				.version("3.4.RELEASE")
				.contact(new Contact().name("Anupam").email("anupamdhauria97@gmail.com").url("http://www.ineuron.ai/course")));
	}
}
