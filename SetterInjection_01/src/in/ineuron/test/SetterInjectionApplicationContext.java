package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjectionApplicationContext {

	public static void main(String[] args) throws IOException {
		

		System.out.println("***********ApplicationContext container starting************");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("The no of bean is: "+factory.getBeanDefinitionCount());
		System.out.println("The Beans are: "+Arrays.toString(factory.getBeanDefinitionNames()));
		System.out.println("***********ApplicationContext container started*************");
		
		System.in.read();
		WishMessageGenerator wm = (WishMessageGenerator)factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("HasCode for wm is: "+wm.hashCode());
		System.out.println(wm.generateMessage("sachin"));
		System.out.println();
		
		WishMessageGenerator wm1 = (WishMessageGenerator)factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("HasCode for wm1 is: "+wm1.hashCode());
		System.out.println(wm.generateMessage("kohli"));
		System.out.println();

		System.out.println("*******Container is closing**********");
		
		
	
		
	}

}
