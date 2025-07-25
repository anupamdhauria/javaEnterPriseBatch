package in.ineuron.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="{in.ineuron}")
@Import(value=PersistenceConfig.class)
public class AppConfig {

}
