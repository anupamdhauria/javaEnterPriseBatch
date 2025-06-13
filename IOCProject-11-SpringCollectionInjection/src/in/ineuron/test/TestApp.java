package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.College;
import in.ineuron.comp.ContactInfo;
import in.ineuron.comp.IplInfo;
import in.ineuron.comp.MarksInfo;
import in.ineuron.comp.UniversityInfo;

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
		
		College college = factory.getBean("college",College.class);
		System.out.println(college);
		
		ContactInfo contactInfo = factory.getBean("contactInfo",ContactInfo.class);
		System.out.println(contactInfo);
		
		UniversityInfo universityInfo = factory.getBean("universityInfo",UniversityInfo.class);
		System.out.println(universityInfo);
		
		IplInfo iplInfo = factory.getBean("ipl",IplInfo.class);
		System.out.println(iplInfo);
		factory.close();
		System.out.println("\n*********Container stopped**********");

	}

}
