package in.ineuron.test;



import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.FlipKart;

public class TestApp {

	public static void main(String[] args) throws IOException {
	
		 System.out.println("********container started*******");
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		 System.out.println("Bean id is:"+Arrays.toString(context.getBeanDefinitionNames()));
		 System.in.read();
		 
		 FlipKart flipkart = context.getBean("flipkart",FlipKart.class);
		 System.out.println(flipkart);
		 System.out.println(flipkart.doShopping(new String[] {"laptop", "mobile"},new float[] {40000.3f,10000f}));
		 context.close();

	}

}
