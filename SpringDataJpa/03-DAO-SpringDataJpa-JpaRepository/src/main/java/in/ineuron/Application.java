package in.ineuron;

import java.util.ArrayList;
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

	private final ICoronaVaccineRepo ICoronaVaccineRepo;

	Application(ICoronaVaccineRepo ICoronaVaccineRepo) {
		this.ICoronaVaccineRepo = ICoronaVaccineRepo;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = SpringApplication.run(Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

//		CoronaVaccine vaccine = new CoronaVaccine("bh","covaxin","india",566.0,3);
		CoronaVaccine vaccine = new CoronaVaccine();
		vaccine.setRequiredDoseCount(2);
		service.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
		System.out.println("------------------------------------------------------------------");

		try {
			CoronaVaccine vaccineById = service.getVaccineById(7L);
			System.out.println(vaccineById);
		 
		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		List<Long> list = new ArrayList<Long>();
		list.add(2L);
		list.add(8L);
		list.add(5L);
		String removeVaccinesByRegNO = service.removeVaccinesByRegNO(list);
		System.out.println(removeVaccinesByRegNO);
		factory.close();

	}

}
