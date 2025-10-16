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
		
		factory.close();

	}

}
