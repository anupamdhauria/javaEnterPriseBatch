package in.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	 @Bean
	  public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Student Management API")
	                        .description("Spring Boot 3.5 Application with Redis Caching and JPA")
	                        .version("1.0.0")
	                        .contact(new Contact()
	                                .name("Anupam Dhauria")
	                                .email("anupam@example.com")
	                                .url("https://github.com/anupamdhauria"))
	                        .license(new License()
	                                .name("Apache 2.0")
	                                .url("http://springdoc.org")));
	    }
}
