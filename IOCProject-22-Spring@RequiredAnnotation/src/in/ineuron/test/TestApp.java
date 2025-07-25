package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.PersonInfo;


public class TestApp {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		PersonInfo person=context.getBean(PersonInfo.class);
		System.out.println(person);
		((AbstractApplicationContext)context).close();
	}

}
