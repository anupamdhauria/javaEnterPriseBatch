package in.ineuron.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.EnggCourse;
public class TestApp {

	public static void main(String[] args) {
		

		System.out.println("***********ApplicationContext container starting************");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		EnggCourse engCourse = factory.getBean("CS",EnggCourse.class);
		System.out.println(engCourse);

		System.out.println("*******Container is closing**********");
		
		
	
		
	}

}
