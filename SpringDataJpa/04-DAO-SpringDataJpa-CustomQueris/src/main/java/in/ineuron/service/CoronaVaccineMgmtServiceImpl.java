package in.ineuron.service;

import java.util.Collection;
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

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public List<CoronaVaccine> fetchByCompany(String company) {
		
		List<CoronaVaccine> listEntities = repo.findByCompany(company);
		List<CoronaVaccine> byCompanyEquals = repo.findByCompanyEquals(company);
		List<CoronaVaccine> byCompanyIs = repo.findByCompanyIs(company);
		
		return byCompanyIs;
	}

	@Override
	public List<CoronaVaccine> fetchByPriceLessThan(Double price) {
		List<CoronaVaccine> priceLessThan = repo.findByPriceLessThan(price);
		return priceLessThan;
	}



	@Override
	public List<CoronaVaccine> fetchByCountryNotIn(Collection<String> countries) {
		List<CoronaVaccine> byCountryNotIn = repo.findByCountryNotIn(countries);
		return byCountryNotIn;
	}

	@Override
	public List<CoronaVaccine> fetchByCountryAndPrice(Collection<String> countries, double startRange,
			double endRange) {
		List<CoronaVaccine> byCountryInAndPriceBetween = repo.findByCountryInAndPriceBetween(countries, startRange, endRange);
		return byCountryInAndPriceBetween;
	}

	
	

}
