package in.ineuron.test;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.controller.MainController;
import in.ineuron.vo.CustomerVO;

public class TestApp {

	public static void main(String[] args) throws IOException {

		// Reading the inputs
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the customerName:: ");
		String customerName = scanner.next();

		System.out.print("Enter the customerAddress:: ");
		String customerAddress = scanner.next();

		System.out.print("Enter the principalAmount:: ");
		String pamt = scanner.next();

		System.out.print("Enter the RateOfInterest:: ");
		String rate = scanner.next();

		System.out.print("Enter the TimePeriod:: ");
		String time = scanner.next();

		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerName(customerName);
		customerVO.setCustomerAddress(customerAddress);
		customerVO.setPamt(pamt);
		customerVO.setRate(rate);
		customerVO.setTime(time);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"/in/ineuron/cfg/applicationContext.xml");

		System.out.println("**************Container Started******************");

		System.in.read();

		MainController controller = factory.getBean("customerController", MainController.class);

		try {
			String result = controller.processController(customerVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Problem occur! please try again");
		}
		System.out.println("\n************Container Stopped***************");
		scanner.close();

	}

}
