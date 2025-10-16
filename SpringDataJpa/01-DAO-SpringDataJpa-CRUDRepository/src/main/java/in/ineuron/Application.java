package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class Application {

	private final ICoronaVaccineRepo ICoronaVaccineRepo;

	Application(ICoronaVaccineRepo ICoronaVaccineRepo) {
		this.ICoronaVaccineRepo = ICoronaVaccineRepo;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
//		CoronaVaccine vaccine = new CoronaVaccine(null,"coveshield","serum","india",345.2,2);
//		service.registerVacine(vaccine);

		/*
		 * List<CoronaVaccine> vaccines=new ArrayList<CoronaVaccine>(); vaccines.add(new
		 * CoronaVaccine(null, "sputnik", "russie", "Russia", 567.8,2));
		 * vaccines.add(new CoronaVaccine(null, "pyzer", "pyzer", "USA", 456.8,2));
		 * vaccines.add(new CoronaVaccine(null, "modera", "modea", "UK", 836.8,2));
		 * 
		 * Iterable<CoronaVaccine>coronaVaccine=service.registerInBatch(vaccines);
		 * coronaVaccine.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		 */
		System.out.println("Available Corona Vaccine with ID:" + service.checkAvailablityByRegNo(2L));
		System.out.println("Count of vaccine:" + service.getVaccineCount());
		service.fetchAllDetails().forEach(System.out::println);

		List<Long> ids = new ArrayList<>();
		ids.add(3L);
		ids.add(4L);
		service.fetchAllDetailsByID(ids).forEach(System.out::println);

		Optional<CoronaVaccine> optional = service.fetchVaccineById(1L);

		if (optional.isPresent())
			System.out.println(optional.get());
		optional.orElseThrow(() -> new IllegalArgumentException("record not found"));

		System.out.println(service.fetchVaccineById(10L).orElse(new CoronaVaccine()));
		System.out.println(service.fetchVaccineById(7L).orElseGet(() -> new CoronaVaccine()));

		System.out.println(service.removeVaccineById(13L));

		CoronaVaccine vaccine = new CoronaVaccine(14L, "sputnik", "russie", "Russia", 567.8, 2);
		System.out.println(service.removeVaccineByObject(vaccine));

		List<Long> idslist = new ArrayList<Long>();
		idslist.add(8L);
		idslist.add(9L);
		idslist.add(10L);
		idslist.add(11L);
		System.out.println(service.removeVaccinesById(idslist));

		factory.close();
	}

}
