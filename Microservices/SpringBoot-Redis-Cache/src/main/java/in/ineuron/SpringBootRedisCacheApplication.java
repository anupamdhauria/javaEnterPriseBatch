package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ineuron.model.Student;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisCacheApplication {

//
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jcf = new JedisConnectionFactory();
//		return jcf;
//	}
//
//
//	@Bean
//	RedisTemplate<String, Student> redisTemplate() {
//		RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		return redisTemplate;
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheApplication.class, args);
	}

}
