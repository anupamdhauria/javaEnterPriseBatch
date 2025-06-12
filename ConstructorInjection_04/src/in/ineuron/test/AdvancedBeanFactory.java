package in.ineuron.test;

import java.io.IOException;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.comp.Student;

public class AdvancedBeanFactory {

	public static void main(String[] args) throws IOException {
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in/ineuron/cfg/ApplicationContext.xml");
		System.out.println("**********container started**********");
		System.in.read();
		
		Student student=factory.getBean("stud1",Student.class);
		System.out.println(student);
		System.out.println("********container closed*************");

	}

}
