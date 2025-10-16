package in.ineuron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.service.ICoronaVaccineMgmtService;
import jakarta.persistence.EntityNotFoundException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		service.fetchVaccinesByCompany("bharat-info").forEach(System.out::println);
		System.out.println("====================================================================");

		service.fetchVaccineByCompanies("pzyer", "covaxin").forEach(System.out::println);
		System.out.println("====================================================================");

		service.fetchVaccineByPriceRange(500.0, 600.0).forEach(System.out::println);
		System.out.println("====================================================================");

		List<Object[]> names = service.fetchVaccineByNames("bh", "zensin");
		for (Object[] objects : names) {
			for (Object obj : objects) {
				System.out.print(obj);
				System.out.println();
			}
		}
		System.out.println("=========================================================================");

		System.out.println("No of records updated is :: " + service.modifyPriceByCountry(800.0, "uk"));
		System.out.println("=========================================================================");
		System.out.println("No of records deleted is :: " + service.removeVaccineByPrice(570.0, 590.0));
		System.out.println("=========================================================================");
		Date date = service.fetchSystemDate();
		System.out.println("The current date info is :: " + date);
		System.out.println("=========================================================================");
		int rowSaved = service.registerVaccine("moderna", "USA", "moderna", 910.0, 3);
		System.out.println("No of record saved is :: " + rowSaved);
		System.out.println("=========================================================================");
		factory.close();

	}

}
