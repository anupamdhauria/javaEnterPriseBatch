package in.ineuron.test;

import java.io.IOException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjectionBeanFactory {

	public static void main(String[] args) throws IOException {
		
		FileSystemResource resource=new FileSystemResource("src/in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********BeanFactory container starting************");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		
		System.out.println("***********BeanFactory container started*************");
		
		System.in.read();
		WishMessageGenerator wm = (WishMessageGenerator)xmlBeanFactory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("HasCode for wm is: "+wm.hashCode());
		System.out.println(wm.generateMessage("sachin"));
		System.out.println();
		
		WishMessageGenerator wm1 = (WishMessageGenerator)xmlBeanFactory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("HasCode for wm1 is: "+wm1.hashCode());
		System.out.println(wm.generateMessage("kohli"));
		System.out.println();

		System.out.println("*******Container is closing**********");
		
		
	
		
	}

}
