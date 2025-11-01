package in.ineuron.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix="demo")
@Data
@Configuration
@EnableConfigurationProperties
public class AppConfig {

	public Map<String,String>properties=new HashMap<String,String>();
	public Map<String,String>props=new HashMap<String,String>();
}
