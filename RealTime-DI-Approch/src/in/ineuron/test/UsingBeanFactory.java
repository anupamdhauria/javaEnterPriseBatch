package in.ineuron.test;

import java.io.IOException;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.comp.FlipKart;

public class UsingBeanFactory {

	public static void main(String[] args) throws IOException {
		 DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		 XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
		 System.out.println("********container started*******");
		 System.in.read();
		 
		 FlipKart flipkart = factory.getBean("flipkart",FlipKart.class);
		 System.out.println(flipkart);
		 System.out.println(flipkart.doShopping(new String[] {"laptop", "mobile"},new float[] {40000.3f,10000f}));
		 

	}

}
