package in.ineuron.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class EmailReportRunner implements ApplicationRunner {

    private final PdfReportRunner pdfReportRunner;

    EmailReportRunner(PdfReportRunner pdfReportRunner) {
        this.pdfReportRunner = pdfReportRunner;
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailReportRunner.run()");
		//printing args in the form of array
		System.out.println("From ApplicationRunner::"+Arrays.asList(args.getSourceArgs()));
		
		//printing non option args
		System.out.println("Non Option Args::"+args.getNonOptionArgs());
		
		//printing option args
		System.out.println("Option args::"+args.getOptionNames());
		
		//list
		
		Set<String> optionNames = args.getOptionNames();
		for(String option:optionNames) {
			System.out.println(option+"         "+args.getOptionValues(option));
		}
		
		if(args.getNonOptionArgs().contains("start")) {
			System.out.println("Taking dump Email for Test");
		}
		
		
		
	}

	

}
