package in.ineuron.test;



import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.FlipKart;

public class TestApp {

	public static void main(String[] args) throws IOException {
	
		 System.out.println("********container started*******");
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		 
		 FlipKart flipkart1 = context.getBean("flipkart1",FlipKart.class);
		 System.out.println(flipkart1);
		 System.out.println(flipkart1.doShopping(new String[] {"laptop", "mobile"},new float[] {40000.3f,10000f}));
		 
		 FlipKart flipkart2 = context.getBean("flipkart2",FlipKart.class);
		 System.out.println(flipkart2);
		 System.out.println(flipkart2.doShopping(new String[] {"keyboard", "mouse"},new float[] {2000.3f,900.0f}));
		 context.close();

	}

}
