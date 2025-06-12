package in.ineuron.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.Student;

public class TestApp {

	public static void main(String[] args) {

		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/ApplicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);

		Object bean1 = factory.getBean("stud1", Student.class);
		System.out.println(bean1);

		Object bean2 = factory.getBean("stud2", Student.class);
		System.out.println(bean2);
		
		Object bean3 = factory.getBean("stud3", Student.class);
		System.out.println(bean3);
	}

}
