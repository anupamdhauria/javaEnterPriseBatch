package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.BillGenerator;

@SpringBootApplication
public class BootProj06ValueAnnotationAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj06ValueAnnotationAppApplication.class, args);
		BillGenerator billGenerator = context.getBean(BillGenerator.class);
		System.out.println(billGenerator);
		((ConfigurableApplicationContext) context).close();
	}

}
