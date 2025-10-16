package in.ineuron.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;
import jakarta.transaction.Transactional;

@Service("service")
@Transactional
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		return  repo.searchVaccineByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchVaccineByCompanies(String comp1, String comp2) {
	
		return repo.searchVaccinesByCompanies(comp1, comp2);
	}

	@Override
	public List<String> fetchVaccineByPriceRange(double min, double max) {
		return repo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<Object[]> fetchVaccineByNames(String name1, String name2) {
		return repo.searchVaccineByNames(name1, name2);
	}

	@Override
	public int modifyPriceByCountry(double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}

	@Override
	public int removeVaccineByPrice(double startPrice, double endPrice) {
		return repo.deleteVaccineByPrice(startPrice, endPrice);
	}

	@Override
	public int registerVaccine(String company, String country, String name, Double price, Integer required_dose_count) {
		return repo.insertVaccine(company, country, name, price, required_dose_count);
	}

	@Override
	public Date fetchSystemDate() {
		return repo.getSystemDate();
	}

	
	
	

}
