package in.ineuron.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.ineuron.comp.WishMessageGenerator;
public class TestApp {

	public static void main(String[] args) {
		

		System.out.println("***********ApplicationContext container starting************\n");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		WishMessageGenerator wmg = factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("HashCode of wmg::"+wmg.hashCode());
		System.out.println(wmg);
		
		System.out.println();
		
		WishMessageGenerator wmg1 = factory.getBean("WishMessageGenerator",WishMessageGenerator.class);
		System.out.println("HashCode of WishMessageGenerator::"+wmg1.hashCode());
		System.out.println(wmg1);

		System.out.println("\n*******Container is closing**********");
		
		
	
		
	}

}
