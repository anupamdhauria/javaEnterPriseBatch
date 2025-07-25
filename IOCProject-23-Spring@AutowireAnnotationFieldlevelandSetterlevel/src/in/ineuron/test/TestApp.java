package in.ineuron.test;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.FlipKart;


public class TestApp {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");

		FlipKart flipkart1 = context.getBean("flipkart",FlipKart.class);
		System.out.println(flipkart1);
		System.out.println(flipkart1.doShopping(new String[] {"laptop", "mobile"},new float[] {40000.3f,10000f}));

		
		((AbstractApplicationContext)context).close();
	}

}
