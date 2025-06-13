package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.PersonInfo;


public class TestApp {

	public static void main(String[] args) throws IOException {

		System.out.println("***********ApplicationContext container starting************");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********ApplicationContext container started*************");

		System.out.println("*********Container started**********");
		System.out.println("Bean id is :: " + Arrays.toString(factory.getBeanDefinitionNames()));

	
		PersonInfo personInfo = factory.getBean("personInfo",PersonInfo.class);
		System.out.println(personInfo);
	
		factory.close();
		System.out.println("\n*********Container stopped**********");

	}

}
