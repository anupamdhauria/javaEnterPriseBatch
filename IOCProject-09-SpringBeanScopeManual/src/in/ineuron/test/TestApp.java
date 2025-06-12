package in.ineuron.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Printer;

public class TestApp {

	public static void main(String[] args) throws IOException {

		System.out.println("***********ApplicationContext container starting************");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********ApplicationContext container started*************");

		Printer p1 = factory.getBean("printer", Printer.class);
		System.out.println(p1);

		System.out.println();

		Printer p2 = factory.getBean("printer", Printer.class);
		System.out.println(p2);

		System.out.println();

		System.out.println("*******Container is closing**********");

	}

}
