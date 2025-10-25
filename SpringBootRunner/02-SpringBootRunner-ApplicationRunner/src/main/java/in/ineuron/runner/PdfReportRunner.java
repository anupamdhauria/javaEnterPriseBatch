package in.ineuron.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class PdfReportRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("PdfReportRunner");
		System.out.println("Arg[0]::"+args[0]);
		System.out.println("Arguments are::"+Arrays.asList(args));
		
	}

}
