package in.ineuron.test;



import java.io.IOException;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.comp.WishMessageGenerator;

public class TestApp {

	public static void main(String[] args) throws IOException {
	
		 System.out.println("********container started*******");
		 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 System.out.println("Bean id is:"+Arrays.toString(context.getBeanDefinitionNames()));
		 
		 WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		 System.out.println(wmg);
		 System.out.println(wmg.wishMessage("ANUPAM"));
		 
		 ((AbstractApplicationContext) context).close();
		 System.out.println("********container closed*******");

	}

}
