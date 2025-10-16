package in.ineuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.service.ICoronaVaccineMgmtService;
import in.ineuron.type.ResultView1;
import in.ineuron.type.ResultView2;
import in.ineuron.type.ResultView3;
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
		
//		List<ResultView2> list = service.searchByCountryOrderByCompanyDesc("pzyer", ResultView2.class);
//		System.out.println(list);
		service.searchByCountryOrderByCompanyDesc("bharat-info", ResultView2.class).forEach(view -> {
			System.out.println(view.getRegNo() + " " + view.getCountry() + " " + view.getPrice());
		});

		service.searchByCountryOrderByCompanyDesc("covaxin", ResultView1.class).forEach(view -> {
			System.out.println(view.getName() + " " + view.getCompany());
		});
		service.searchByCountryOrderByCompanyDesc("coronil", ResultView3.class).forEach(view -> {
			System.out.println(view.getCompany()+" "+view.getName()+" "+view.getPrice());
		});
		factory.close();

	}

}
