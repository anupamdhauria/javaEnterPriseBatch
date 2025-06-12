package in.ineuron.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.Student;

public class Beanfactory {

	public static void main(String[] args) {

		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/ApplicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);

		Student bean1 = factory.getBean("stud1", Student.class);
		System.out.println(bean1);
		System.out.println();
		
		Student bean2 = factory.getBean("stud2", Student.class);
		System.out.println(bean2);
		System.out.println();
		
		Student bean3 = factory.getBean("stud3", Student.class);
		System.out.println(bean3);
		System.out.println();
		
		Student bean4 = factory.getBean("stud4", Student.class);
		System.out.println(bean4);
		System.out.println();
		
	
	}

}
