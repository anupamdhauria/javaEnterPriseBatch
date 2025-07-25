package in.ineuron.test;



import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Voter;

public class TestApp {

	public static void main(String[] args) throws IOException {
	
		 System.out.println("********container started*******");
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		 System.out.println("Bean id is:"+Arrays.toString(context.getBeanDefinitionNames()));	
		 
		 Voter voter=context.getBean(Voter.class);
		 System.out.println(voter);
		 System.out.println(voter.checkEligibility());
		 context.close();

	}

}
