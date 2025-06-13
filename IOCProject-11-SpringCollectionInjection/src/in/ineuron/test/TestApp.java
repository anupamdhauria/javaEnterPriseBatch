package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.MarksInfo;

public class TestApp {

	public static void main(String[] args) throws IOException {

		System.out.println("***********ApplicationContext container starting************");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********ApplicationContext container started*************");

		System.out.println("*********Container started**********");
		System.out.println("Bean id is :: " + Arrays.toString(factory.getBeanDefinitionNames()));

		System.in.read();

		MarksInfo marksInfo = factory.getBean("marksInfo",MarksInfo.class);
		System.out.println(marksInfo);

		factory.close();
		System.out.println("\n*********Container stopped**********");

	}

}
